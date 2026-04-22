package l13.collections.usecases;

import java.util.Vector;

public class VectorUseCaseExample {
    public static void main(String[] args) {
        // Real use case: shared log in old synchronized systems.
        Vector<String> sharedLog = new Vector<>();
        sharedLog.add("Teacher logged in");
        sharedLog.add("Student joined class");

        System.out.println("Where to use Vector: legacy code needing synchronized list operations.");
        System.out.println("Shared log: " + sharedLog);
    }
}
