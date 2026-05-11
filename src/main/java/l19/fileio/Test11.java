package l19.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test11 {
    public static void main(String[] args) throws IOException {
        Files.walk(Path.of("."))
                .filter(p -> p.getFileName().toString().endsWith(".pdf"))
                .forEach(System.out::println);
    }
}
