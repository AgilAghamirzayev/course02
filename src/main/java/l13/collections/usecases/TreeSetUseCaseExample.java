package l13.collections.usecases;

import java.util.TreeSet;

public class TreeSetUseCaseExample {
    public static void main(String[] args) {
        // Real use case: dictionary words in alphabetical order.
        TreeSet<String> dictionaryWords = new TreeSet<>();
        dictionaryWords.add("banana");
        dictionaryWords.add("apple");
        dictionaryWords.add("carrot");

        System.out.println("Where to use TreeSet: auto-sorted unique values.");
        System.out.println("Dictionary words: " + dictionaryWords);
        System.out.println("Words starting before 'c': " + dictionaryWords.headSet("c"));
    }
}
