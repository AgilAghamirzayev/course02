package l15.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l09.oop.inheritance.objectclass.inclass.inheritance.part1.part3.A;
import l14.colelctions.inclass.s2.Person1;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add(4, "test");

        List<Object> a = new ArrayList<>();
        a.add("test");
        a.add(new Person1("", 1));
        a.add(1);
        a.add(1.4);

        String o = (String) a.get(1);
        o.isBlank();

        for (Object object : a) {

        }
    }
}
