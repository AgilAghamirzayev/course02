package l19.fileio;

import java.nio.file.Path;

public class Test9 {
    public static void main(String[] args) {
        Path path = Path.of("data/data.txt");
        System.out.println(path.getFileName()); // users.txt
        System.out.println(path.getParent());   // data
        System.out.println(path.getRoot());     // / (root)
        System.out.println(path);
    }
}
