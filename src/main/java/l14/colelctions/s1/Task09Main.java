package l14.colelctions.s1;

import java.util.Set;

public class Task09Main {
    public static void main(String[] args) {
        BookIndexService service = new BookIndexService();

        service.indexBook(new Book(1, "The Hobbit", "J.R.R. Tolkien", Set.of("Fantasy", "Adventure")));
        service.indexBook(new Book(2, "Java Concurrency", "Brian Goetz", Set.of("Tech", "Java")));
        service.indexBook(new Book(3, "The Silmarillion", "J.R.R. Tolkien", Set.of("Fantasy", "Lore")));
        service.indexBook(new Book(4, "Clean Code", "Robert Martin", Set.of("Tech", "Best Practices")));

        System.out.println("--- Search by ID (1) ---");
        System.out.println(service.findById(1));

        System.out.println("\n--- Search by Author (J.R.R. Tolkien) ---");
        service.findByAuthor("J.R.R. Tolkien").forEach(System.out::println);

        System.out.println("\n--- Search by Tag (Tech) ---");
        service.findByTag("Tech").forEach(System.out::println);
        
        System.out.println("\n--- Search by Non-existent Tag (Cooking) ---");
        System.out.println("Results found: " + service.findByTag("Cooking").size());
    }
}