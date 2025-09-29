package bookslibrary.repository;

import module java.base;
import bookslibrary.model.Loan;

public interface ILoanRepository {
    void save(Loan loan);

    Optional<Loan> findById(String id);

    List<Loan> findAll();

    List<Loan> findByUserId(String userId);
}
