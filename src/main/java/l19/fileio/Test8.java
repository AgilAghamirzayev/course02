package l19.fileio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test8 {
    public static void main(String[] args) {

        try {
            String content = Files.readString(Path.of("data.txt"), StandardCharsets.UTF_8);
            Files.writeString(Path.of("data.txt"), content.toUpperCase());
            System.out.println(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
