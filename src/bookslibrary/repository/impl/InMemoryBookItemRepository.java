package bookslibrary.repository.impl;

import module java.base;
import bookslibrary.model.BookItem;
import bookslibrary.repository.IBookItemRepository;

public class InMemoryBookItemRepository implements IBookItemRepository {
    private final Map<String, BookItem> items = new HashMap<>();

    @Override
    public void save(BookItem bookItem) {
        items.put(bookItem.getId(), bookItem);
    }

    @Override
    public Optional<BookItem> findById(String id) {
        return Optional.ofNullable(items.get(id));
    }

    @Override
    public List<BookItem> findAll() {
        return new ArrayList<>(items.values());
    }
}
