package bookslibrary.repository.impl;

import bookslibrary.model.Book;
import bookslibrary.repository.IBookRepository;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryBookRepository implements IBookRepository {
    private final Map<String, Book> books = new HashMap<>();

    @Override
    public void save(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public Optional<Book> findById(String id) {
        return Optional.ofNullable(books.get(id));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public List<Book> searchByTitle(String keyword) {
        return books.values().stream()
                       .filter(b -> b.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                       .collect(Collectors.toList());
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return books.values().stream()
                       .filter(b -> b.getAuthor().toLowerCase().contains(author.toLowerCase()))
                       .collect(Collectors.toList());
    }
}
