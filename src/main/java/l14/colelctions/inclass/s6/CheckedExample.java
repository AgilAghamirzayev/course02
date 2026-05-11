package l14.colelctions.inclass.s6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExample {

    public static String readFirstLine(String file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            try {
                String string = br.readLine();
                br.close();
                return string;
            } catch (IOException e) {

                e.printStackTrace();
                System.out.println("File not found");
                br.close();
                throw new RuntimeException("sbsbhsdbh");
            }

        } catch (IOException e) {
            System.out.println(e);
        }

        return "";

    }

    public static void main(String[] args) {

        CheckedExample.readFirstLine("test.txt");
        System.out.println("sjsj");
    }

}