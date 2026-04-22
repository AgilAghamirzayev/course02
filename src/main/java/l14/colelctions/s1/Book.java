package l14.colelctions.s1;

import java.util.Objects;
import java.util.Set;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final Set<String> tags;

    public Book(int id, String title, String author, Set<String> tags) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Set<String> getTags() { return tags; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %s by %s | Tags: %s", id, title, author, tags);
    }
}