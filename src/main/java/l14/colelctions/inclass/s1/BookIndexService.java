package l14.colelctions.inclass.s1;

import java.util.*;

public class BookIndexService {
    private final Map<Integer, Book> idIndex = new HashMap<>();
    private final Map<String, List<Book>> authorIndex = new HashMap<>();
    private final Map<String, Set<Book>> tagIndex = new HashMap<>();

    //map.get(key) -> value
    public void indexBook(Book book) {
        idIndex.put(book.getId(), book);

        List<Book> books = authorIndex.get(book.getAuthor());

        if (books == null) {
            authorIndex.put(book.getAuthor(), new ArrayList<>(List.of(book)));
        } else  {
            books.add(book);
        }

        for (String tag : book.getTags()) {
            Set<Book> currBooks = tagIndex.get(tag);
            if (currBooks == null) {
                tagIndex.put(tag, new HashSet<>(Set.of(book)));
            } else {
                currBooks.add(book);
            }
        }

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