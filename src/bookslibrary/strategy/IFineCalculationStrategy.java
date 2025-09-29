package bookslibrary.strategy;

import bookslibrary.model.Loan;

public interface IFineCalculationStrategy {
    double calculateFine(Loan loan);
}
