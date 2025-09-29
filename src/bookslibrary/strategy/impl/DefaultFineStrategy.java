package bookslibrary.strategy.impl;

import module java.base;
import bookslibrary.model.Loan;
import bookslibrary.strategy.IFineCalculationStrategy;

public class DefaultFineStrategy implements IFineCalculationStrategy {

    private final double finePerDay;

    public DefaultFineStrategy(double finePerDay) {
        this.finePerDay = finePerDay;
    }

    @Override
    public double calculateFine(Loan loan) {
        LocalDate today = LocalDate.now();
        if (loan.getDueDate().isBefore(today)) {
            long overdueDays = ChronoUnit.DAYS.between(loan.getDueDate(), today);
            return overdueDays * finePerDay;
        }
        return 0.0;
    }
}
