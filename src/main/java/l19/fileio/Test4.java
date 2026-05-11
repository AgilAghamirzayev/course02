package l19.fileio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test4 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("data.txt")))) {
            byte[] chunk = new byte[4096];
            System.out.println(bis.read(chunk));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
    }
}
