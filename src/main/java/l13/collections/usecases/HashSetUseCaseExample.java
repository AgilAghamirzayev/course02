package l13.collections.usecases;

import java.util.HashSet;

public class HashSetUseCaseExample {
    public static void main(String[] args) {
        // Real use case: fast check if email already exists.
        HashSet<String> emails = new HashSet<>();
        emails.add("kid1@school.com");
        emails.add("kid2@school.com");

        String newEmail = "kid1@school.com";
        boolean alreadyExists = emails.contains(newEmail);

        System.out.println("Where to use HashSet: fastest uniqueness checks.");
        System.out.println(newEmail + " already exists? " + alreadyExists);
    }
}
