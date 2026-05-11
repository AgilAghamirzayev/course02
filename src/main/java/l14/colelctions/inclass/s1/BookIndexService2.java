package l14.colelctions.inclass.s1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookIndexService2 {
    private final Map<Integer, Book> idIndex = new HashMap<>();
    private final Map<String, List<Book>> authorIndex = new HashMap<>();
    private final Map<String, Set<Book>> tagIndex = new HashMap<>();

    //map.get(key) -> value
    public void indexBook(Book book) {
        idIndex.put(book.getId(), book);
        authorIndex.computeIfAbsent(book.getAuthor(), k -> new ArrayList<>()).add(book);
        book.getTags().forEach(tag -> tagIndex.computeIfAbsent(tag,  t -> new HashSet<>()).add(book));
    }

    public Book findById(int id) {
        return idIndex.get(id);
    }

    public List<Book> findByAuthor(String author) {
        return authorIndex.getOrDefault(author, List.of());
    }

    public Set<Book> findByTag(String tag) {
        return tagIndex.getOrDefault(tag, Set.of());
    }

}