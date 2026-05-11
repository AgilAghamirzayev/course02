package l19.fileio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BinaryCopyDemo {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("data.txt");
        int data;
        while ((data = fis.read()) != -1) {
            System.out.print((char) data);
        }
        fis.close();
//        try {
//            copyFile(new File("src/main/resources/file.txt"), new File("src/main/resources/file-copy.txt"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void copyFile(File src, File dst) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(src));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(dst))) {
            byte[] buffer = new byte[8192];
            int read;
            while ((read = in.read(buffer)) != -1) {
                System.out.println(read);
//                out.write(buffer, 0, read);
            }
        }
    }
}