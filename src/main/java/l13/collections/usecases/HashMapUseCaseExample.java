package l13.collections.usecases;

import java.util.HashMap;

public class HashMapUseCaseExample {
    public static void main(String[] args) {
        // Real use case: count word frequency quickly.
        HashMap<String, Integer> wordCount = new HashMap<>();
        String[] words = {"java", "collection", "java", "map", "java"};

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Where to use HashMap: fast lookups and updates by key.");
        System.out.println("Word frequency: " + wordCount);
    }
}
