package l13.collections.usecases;

import java.util.HashMap;
import java.util.Map;

public class MapUseCaseExample {
    public static void main(String[] args) {
        // Real use case: student ID to student name mapping.
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(1001, "Ayla");
        studentMap.put(1002, "Rashad");
        studentMap.put(1003, "Farid");

        System.out.println("Where to use Map: key-value relationships.");
        System.out.println("Student with ID 1002: " + studentMap.get(1002));
    }
}
