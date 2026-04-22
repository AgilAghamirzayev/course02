package l13.collections.usecases;

import java.util.TreeMap;

public class TreeMapUseCaseExample {
    public static void main(String[] args) {
        // Real use case: timetable sorted by hour.
        TreeMap<Integer, String> timetable = new TreeMap<>();
        timetable.put(10, "Math");
        timetable.put(8, "English");
        timetable.put(9, "Science");

        System.out.println("Where to use TreeMap: sorted keys with key-value pairs.");
        System.out.println("Timetable: " + timetable);
        System.out.println("First class: " + timetable.firstEntry());
    }
}
