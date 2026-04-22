package l13.collections.usecases;

import java.util.HashSet;
import java.util.Set;

public class SetUseCaseExample {
    public static void main(String[] args) {
        // Real use case: unique usernames.
        Set<String> usernames = new HashSet<>();
        usernames.add("tom");
        usernames.add("mia");
        usernames.add("tom"); // duplicate ignored

        System.out.println("Where to use Set: keep unique values only.");
        System.out.println("Usernames: " + usernames);
    }
}
