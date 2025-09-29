package bookslibrary.service;

import module java.base;
import bookslibrary.exception.BookNotAvailableException;
import bookslibrary.exception.MaxBooksIssuedException;
import bookslibrary.exception.UserNotFoundException;
import bookslibrary.model.Loan;

public interface ICirculationService {
    Loan checkout(String userId, String bookItemId) throws BookNotAvailableException, MaxBooksIssuedException, UserNotFoundException;

    double returnBook(String bookItemId) throws BookNotAvailableException;

    void renew(String bookItemId);

    List<Loan> getLoansForUser(String userId);
}
