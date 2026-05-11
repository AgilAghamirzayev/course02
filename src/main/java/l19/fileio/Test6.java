package l19.fileio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test6 {


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        File FILE = new File("book.pdf");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(FILE))) {
            byte[] chunk = new byte[4098];
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("book.pdf", true));
            int read = bis.read(chunk);

            while (read != -1) {
                bos.write(chunk, 0, read);
                read = bis.read(chunk);
            }

            bos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - l);
    }
}
