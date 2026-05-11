package l14.colelctions.inclass.s01;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        HashSet<String> o1 = new HashSet<>();
        LinkedHashSet<String> o2 = new LinkedHashSet<>();
        TreeSet<String> o3 = new TreeSet<>();

        o1.add("Ali");
        o1.add("Ali");
        o1.add("Ali");
        o1.add("Vali");
        o1.add("Aysu");
        o1.add(null);
        o1.add(null);

        o1.forEach(System.out::println);
        System.out.println();

        o2.add("Ali");
        o2.add("Ali");
        o2.add("Vali");
        o2.add("Aysu");
        o2.add(null);
        o2.add(null);

        o2.forEach(System.out::println);

        System.out.println();

        String  a = "";
        o3.add("Ali");
        o3.add("Ali");
        o3.add("Alye");
        o3.add("Vali");
        o3.add("Aysu");
//        o3.add(null);
//        o3.add(null);
        o3.forEach(System.out::println);




    }
}
