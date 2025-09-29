package bookslibrary.repository;

import module java.base;
import bookslibrary.model.BookItem;

public interface IBookItemRepository {
    void save(BookItem bookItem);

    Optional<BookItem> findById(String id);

    List<BookItem> findAll();
}
