package bookslibrary.model;

import bookslibrary.model.user.BaseUser;

import java.time.LocalDate;

public class Loan {
    private final String id;
    private final BookItem bookItem;
    private final BaseUser user;
    private final LocalDate issueDate;
    private LocalDate dueDate;

    public Loan(String id, BookItem bookItem, BaseUser user, LocalDate issueDate, LocalDate dueDate) {
        this.id = id;
        this.bookItem = bookItem;
        this.user = user;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public BookItem getBookItem() {
        return bookItem;
    }

    public BaseUser getUser() {
        return user;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Loan{" + "id='" + id + '\'' + ", bookItem=" + bookItem + ", user=" + user.getName() + ", dueDate=" + dueDate + '}';
    }
}
