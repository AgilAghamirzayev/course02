package l19.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test7 {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("data.txt");
            while (reader.ready()) {
                System.out.print((char) reader.read());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
