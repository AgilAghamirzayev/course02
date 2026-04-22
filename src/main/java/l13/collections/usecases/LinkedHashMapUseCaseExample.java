package l13.collections.usecases;

import java.util.LinkedHashMap;

public class LinkedHashMapUseCaseExample {
    public static void main(String[] args) {
        // Real use case: show pages in order users visited.
        LinkedHashMap<Integer, String> visitedPages = new LinkedHashMap<>();
        visitedPages.put(1, "Home");
        visitedPages.put(2, "Courses");
        visitedPages.put(3, "Pricing");

        System.out.println("Where to use LinkedHashMap: key-value data with insertion order.");
        System.out.println("Visited pages: " + visitedPages);
    }
}
