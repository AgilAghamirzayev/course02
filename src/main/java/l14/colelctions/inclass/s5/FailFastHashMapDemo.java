package l14.colelctions.inclass.s5;

import java.util.*;

public class FailFastHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Book");
        map.put(2, "Pen");
        map.put(3, "Notebook");

        for (Integer key : map.keySet()) {
            if (key == 2) {
                map.put(4, "Pencil"); // iterasiya zamanı struktur dəyişir
            }
        }
    }
}