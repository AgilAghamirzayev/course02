package l14.colelctions.inclass.s6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExample3 {

    public static String readFirstLine(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
            throw new RuntimeException("sbsbhsdbh");
        }
    }

    public static void main(String[] args) {
        CheckedExample3.readFirstLine("test.txt");
        System.out.println("sjsj");
    }

}