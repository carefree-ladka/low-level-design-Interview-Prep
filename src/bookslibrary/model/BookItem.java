package bookslibrary.model;

import bookslibrary.enums.BookStatus;

public class BookItem {
    private final String id;
    private final Book book;
    private BookStatus status;
    private String shelfLocation;

    public BookItem(String id, Book book, BookStatus status, String shelfLocation) {
        this.id = id;
        this.book = book;
        this.status = status;
        this.shelfLocation = shelfLocation;
    }

    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    @Override
    public String toString() {
        return "BookItem{" + "id='" + id + '\'' + ", book=" + book + ", status=" + status + '}';
    }
}
