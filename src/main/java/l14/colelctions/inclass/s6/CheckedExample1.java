package l14.colelctions.inclass.s6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExample1 {

    public static String readFirstLine(String file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            try {
                String string = br.readLine();
                return string;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("File not found");
                throw new RuntimeException("sbsbhsdbh");
            } finally {
                br.close();
            }

        } catch (IOException e) {
            System.out.println(e);
        }

        return "";

    }

    public static void main(String[] args) {

        CheckedExample1.readFirstLine("test.txt");
        System.out.println("sjsj");
    }

}