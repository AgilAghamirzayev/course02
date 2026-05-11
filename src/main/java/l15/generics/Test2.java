package l15.generics;

import java.util.ArrayList;
import java.util.List;
import l14.colelctions.inclass.s2.Person1;

public class Test2 {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("test");

        String string = a.get(1);

        for (String s : a) {
           if (s.isBlank()) {
               System.out.println("");
           }
        }
    }
}
