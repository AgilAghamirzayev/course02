package l13.collections.usecases;

import java.util.LinkedHashSet;

public class LinkedHashSetUseCaseExample {
    public static void main(String[] args) {
        // Real use case: unique recent search words while keeping insertion order.
        LinkedHashSet<String> recentSearches = new LinkedHashSet<>();
        recentSearches.add("cat");
        recentSearches.add("dog");
        recentSearches.add("lion");
        recentSearches.add("dog");

        System.out.println("Where to use LinkedHashSet: unique data with insertion order.");
        System.out.println("Recent searches: " + recentSearches);
    }
}
