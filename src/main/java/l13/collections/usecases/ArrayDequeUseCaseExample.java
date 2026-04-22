package l13.collections.usecases;

import java.util.ArrayDeque;

public class ArrayDequeUseCaseExample {
    public static void main(String[] args) {
        // Real use case: browser back/forward style navigation.
        ArrayDeque<String> pages = new ArrayDeque<>();
        pages.push("Home");
        pages.push("Courses");
        pages.push("Java Collections");

        String back = pages.pop();

        System.out.println("Where to use ArrayDeque: fast stack/queue without null values.");
        System.out.println("Back from page: " + back);
        System.out.println("Current page stack: " + pages);
    }
}
