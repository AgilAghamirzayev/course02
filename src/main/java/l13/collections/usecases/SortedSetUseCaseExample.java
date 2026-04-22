package l13.collections.usecases;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetUseCaseExample {
    public static void main(String[] args) {
        // Real use case: sorted leaderboard scores.
        SortedSet<Integer> scores = new TreeSet<>();
        scores.add(78);
        scores.add(92);
        scores.add(85);
        scores.add(92);

        System.out.println("Where to use SortedSet: unique values in sorted order.");
        System.out.println("Scores: " + scores);
        System.out.println("Best score: " + scores.last());
    }
}
