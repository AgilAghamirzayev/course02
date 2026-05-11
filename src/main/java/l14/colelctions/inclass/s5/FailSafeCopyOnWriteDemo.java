package l14.colelctions.inclass.s5;

import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeCopyOnWriteDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(new String[] {"A", "B", "C"});

        for (String s : list) {
            if (s.equals("B")) {
                list.add("D");
            }
        }

        System.out.println(list); // [A, B, C, D]
    }
}