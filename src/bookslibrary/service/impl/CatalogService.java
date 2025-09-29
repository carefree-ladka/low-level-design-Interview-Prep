package bookslibrary.service.impl;

import module java.base;
import bookslibrary.model.Book;
import bookslibrary.repository.IBookRepository;
import bookslibrary.service.ICatalogService;

public class CatalogService implements ICatalogService {
    private final IBookRepository bookRepository;

    public CatalogService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> findBookById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return bookRepository.searchByTitle(title);
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return bookRepository.searchByAuthor(author);
    }
}
