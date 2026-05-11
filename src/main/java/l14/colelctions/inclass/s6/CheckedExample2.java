package l14.colelctions.inclass.s6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExample2 {

    public static String readFirstLine(String file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader br = new BufferedReader(fileReader)) {

            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
            throw new RuntimeException("sbsbhsdbh");
        }

    }

    public static void main(String[] args) {

        CheckedExample2.readFirstLine("test.txt");
        System.out.println("sjsj");
    }

}