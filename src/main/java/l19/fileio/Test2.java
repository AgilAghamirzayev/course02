package l19.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) {
        File inFile = new File("data.txt");
        StringBuffer sb = new StringBuffer();

        try (FileInputStream fis = new FileInputStream(inFile)) {
            while (fis.available() > 0) {
                sb.append((char) fis.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sb);
    }
}
