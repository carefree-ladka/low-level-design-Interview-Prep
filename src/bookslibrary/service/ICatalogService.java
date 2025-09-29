package bookslibrary.service;

import module java.base;
import bookslibrary.model.Book;

public interface ICatalogService {
    void addBook(Book book);

    Optional<Book> findBookById(String id);

    List<Book> searchByTitle(String title);

    List<Book> searchByAuthor(String author);
}
