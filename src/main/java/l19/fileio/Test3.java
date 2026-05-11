package l19.fileio;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test3 {
    public static void main(String[] args) {
        byte[] dataBytes = "event=login".getBytes();
        try (FileOutputStream fos = new FileOutputStream("out.bin", true)) {
            fos.write(dataBytes);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
