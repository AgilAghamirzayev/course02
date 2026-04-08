package l9.oop.inheritance.objectclass.inclass.inheritance.part3;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static Map<Long, String> map = new HashMap<>();
    public static void main(String[] args) {
        long id = 1L;
        while (true) {
            System.out.println(">" + map.get(id) + "<");
            map.put(id++, "2");
        }

    }
}
