package l14.colelctions.inclass.s5;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Order-1");
        map.put(2, "Order-2");
        map.put(3, "Order-3");

        for (Integer k : map.keySet()) {
            if (k == 2) {
                map.put(4, "Order-4"); // iterasiya zamanı update
            }
        }

        System.out.println(map); // exception yoxdur
    }
}