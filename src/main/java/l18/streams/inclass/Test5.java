package l18.streams.inclass;

import java.util.ArrayList;

public class Test5 {
    public static void main(String[] args) {
        String[] words = {"Java", "Stream"};

        String word1 = words[0];
        String word2 = words[1];

        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        ArrayList<Character> objects = new ArrayList<>();

        for (char c : charArray1) {
            objects.add(c);
        }

        for (char c : charArray2) {
            objects.add(c);
        }

        System.out.println(objects);


    }
}
