package bookslibrary.service.impl;

import module java.base;
import bookslibrary.enums.BookStatus;
import bookslibrary.exception.BookNotAvailableException;
import bookslibrary.exception.MaxBooksIssuedException;
import bookslibrary.exception.UserNotFoundException;
import bookslibrary.factory.IdGenerator;
import bookslibrary.model.BookItem;
import bookslibrary.model.Loan;
import bookslibrary.model.user.BaseUser;
import bookslibrary.repository.IBookItemRepository;
import bookslibrary.repository.ILoanRepository;
import bookslibrary.repository.IUserRepository;
import bookslibrary.service.ICirculationService;
import bookslibrary.service.INotificationService;
import bookslibrary.strategy.IFineCalculationStrategy;


public class CirculationService implements ICirculationService {
    private final IBookItemRepository bookItemRepo;
    private final IUserRepository userRepo;
    private final ILoanRepository loanRepo;
    private final IFineCalculationStrategy fineStrategy;
    private final INotificationService notificationService;

    public CirculationService(IBookItemRepository bookItemRepo, IUserRepository userRepo,
                              ILoanRepository loanRepo, IFineCalculationStrategy fineStrategy,
                              INotificationService notificationService) {
        this.bookItemRepo = bookItemRepo;
        this.userRepo = userRepo;
        this.loanRepo = loanRepo;
        this.fineStrategy = fineStrategy;
        this.notificationService = notificationService;
    }

    @Override
    public Loan checkout(String userId, String bookItemId) throws BookNotAvailableException, MaxBooksIssuedException, UserNotFoundException {
        BaseUser user = userRepo.findById(userId)
                                .orElseThrow(() -> new UserNotFoundException("User not found"));
        BookItem item = bookItemRepo.findById(bookItemId)
                                .orElseThrow(() -> new BookNotAvailableException("Book item not found"));

        if (item.getStatus() != BookStatus.AVAILABLE) {
            throw new BookNotAvailableException("Book not available");
        }

        List<Loan> userLoans = loanRepo.findByUserId(userId);
        if (userLoans.size() >= user.getMaxAllowedBooks()) {
            throw new MaxBooksIssuedException("User has reached max allowed books");
        }

        item.setStatus(BookStatus.ISSUED);
        Loan loan = new Loan(IdGenerator.generate(), item, user, LocalDate.now(), LocalDate.now().plusDays(14));
        loanRepo.save(loan);

        notificationService.notifyUser(user.getEmail(), "Book Issued", "You have issued " + item.getBook().getTitle());
        return loan;
    }

    @Override
    public double returnBook(String bookItemId) throws BookNotAvailableException {
        BookItem item = bookItemRepo.findById(bookItemId)
                                .orElseThrow(() -> new BookNotAvailableException("Book item not found"));

        Optional<Loan> loanOpt = loanRepo.findAll().stream()
                                         .filter(l -> l.getBookItem().getId().equals(bookItemId))
                                         .findFirst();

        if (loanOpt.isEmpty()) return 0.0;

        Loan loan = loanOpt.get();
        item.setStatus(BookStatus.AVAILABLE);

        double fine = fineStrategy.calculateFine(loan);
        notificationService.notifyUser(loan.getUser().getEmail(), "Book Returned", "Book returned. Fine: " + fine);
        return fine;
    }

    @Override
    public void renew(String bookItemId) {
        Optional<Loan> loanOpt = loanRepo.findAll().stream()
                                         .filter(l -> l.getBookItem().getId().equals(bookItemId))
                                         .findFirst();

        if (loanOpt.isPresent()) {
            Loan loan = loanOpt.get();
            loan.setDueDate(loan.getDueDate().plusDays(14));
            notificationService.notifyUser(loan.getUser().getEmail(), "Book Renewed", "Due date extended to " + loan.getDueDate());
        }
    }

    @Override
    public List<Loan> getLoansForUser(String userId) {
        return loanRepo.findByUserId(userId);
    }
}

