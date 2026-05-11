package l19.fileio;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test5 {
    public static void main(String[] args) {
        try (BufferedOutputStream bos =
                     new BufferedOutputStream(new FileOutputStream("data1.txt", true))) {
            bos.write("H".getBytes());
            bos.flush();

            bos.write("H".getBytes());
//            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
