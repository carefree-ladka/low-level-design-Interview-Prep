package bookslibrary.repository;

import module java.base;
import bookslibrary.model.Book;

public interface IBookRepository {
    void save(Book book);

    Optional<Book> findById(String id);

    List<Book> findAll();

    List<Book> searchByTitle(String keyword);

    List<Book> searchByAuthor(String author);
}
