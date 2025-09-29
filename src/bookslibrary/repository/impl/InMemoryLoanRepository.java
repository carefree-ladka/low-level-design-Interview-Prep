package bookslibrary.repository.impl;

import module java.base;
import bookslibrary.model.Loan;
import bookslibrary.repository.ILoanRepository;

public class InMemoryLoanRepository implements ILoanRepository {
    private final Map<String, Loan> loans = new HashMap<>();

    @Override
    public void save(Loan loan) {
        loans.put(loan.getId(), loan);
    }

    @Override
    public Optional<Loan> findById(String id) {
        return Optional.ofNullable(loans.get(id));
    }

    @Override
    public List<Loan> findAll() {
        return new ArrayList<>(loans.values());
    }

    @Override
    public List<Loan> findByUserId(String userId) {
        return loans.values().stream()
                       .filter(loan -> loan.getUser().getId().equals(userId))
                       .collect(Collectors.toList());
    }
}
