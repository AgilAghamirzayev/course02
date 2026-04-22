package l14.colelctions.s1;

import java.util.*;

public class BookIndexService {
    private final Map<Integer, Book> idIndex = new HashMap<>();
    private final Map<String, List<Book>> authorIndex = new HashMap<>();
    private final Map<String, Set<Book>> tagIndex = new HashMap<>();

    public void indexBook(Book book) {

    }

    public Book findById(int id) {
        return null;
    }

    public List<Book> findByAuthor(String author) {
        return null;
    }

    public Set<Book> findByTag(String tag) {
        return null;
    }
}