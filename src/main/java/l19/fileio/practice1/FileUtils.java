package l19.fileio.practice1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FileUtils {
    private FileUtils() {
    }

    public static List<String> readAll(Path path) {
        try {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Could not read storage: " + path, e);
        }
    }

    public static void writeAtomically(Path target, List<String> lines) {
        Path temp = target.resolveSibling(target.getFileName() + ".tmp");
        try {
            Files.write(temp, lines, StandardCharsets.UTF_8);
            Files.move(temp, target, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        } catch (IOException moveFail) {
            try {
                Files.move(temp, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException fallbackFail) {
                throw new IllegalStateException("Could not save storage: " + target, fallbackFail);
            }
        }
    }

}
