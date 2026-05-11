package l14.colelctions.inclass.s6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExample4 {

    public static String readFirstLine(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        CheckedExample4.readFirstLine("test.txt");
        System.out.println("sjsj");
    }

}