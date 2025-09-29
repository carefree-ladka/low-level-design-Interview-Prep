package bookslibrary;

import bookslibrary.enums.BookStatus;
import bookslibrary.exception.BookNotAvailableException;
import bookslibrary.exception.MaxBooksIssuedException;
import bookslibrary.exception.UserNotFoundException;
import bookslibrary.factory.IdGenerator;
import bookslibrary.model.Book;
import bookslibrary.model.BookItem;
import bookslibrary.model.Loan;
import bookslibrary.model.user.BaseUser;
import bookslibrary.model.user.Faculty;
import bookslibrary.model.user.Guest;
import bookslibrary.model.user.Student;
import bookslibrary.repository.IBookItemRepository;
import bookslibrary.repository.IBookRepository;
import bookslibrary.repository.ILoanRepository;
import bookslibrary.repository.IUserRepository;
import bookslibrary.repository.impl.InMemoryBookItemRepository;
import bookslibrary.repository.impl.InMemoryBookRepository;
import bookslibrary.repository.impl.InMemoryLoanRepository;
import bookslibrary.repository.impl.InMemoryUserRepository;
import bookslibrary.service.ICatalogService;
import bookslibrary.service.ICirculationService;
import bookslibrary.service.INotificationService;
import bookslibrary.service.impl.CatalogService;
import bookslibrary.service.impl.CirculationService;
import bookslibrary.service.impl.NotificationService;
import bookslibrary.strategy.impl.DefaultFineStrategy;

import java.util.List;

public class Main {
    void main() throws UserNotFoundException, MaxBooksIssuedException, BookNotAvailableException {
        // Repositories (using interface types)
        IBookRepository bookRepo = new InMemoryBookRepository();
        IBookItemRepository bookItemRepo = new InMemoryBookItemRepository();
        IUserRepository userRepo = new InMemoryUserRepository();
        ILoanRepository loanRepo = new InMemoryLoanRepository();

        // Services
        ICatalogService catalogService = new CatalogService(bookRepo);
        INotificationService notificationService = new NotificationService();
        DefaultFineStrategy fineStrategy = new DefaultFineStrategy(5.0); // 5 currency units per day
        ICirculationService circulationService = new CirculationService(
                bookItemRepo, userRepo, loanRepo, fineStrategy, notificationService
        );

        // Sample Books
        Book book1 = new Book(IdGenerator.generate(), "Clean Code", "Robert C. Martin", "9780132350884", "Prentice Hall", List.of("Software", "Programming"));
        Book book2 = new Book(IdGenerator.generate(), "Design Patterns", "Erich Gamma", "9780201633610", "Addison-Wesley", List.of("Software", "Design"));
        catalogService.addBook(book1);
        catalogService.addBook(book2);

        // Book Items
        BookItem item1 = new BookItem(IdGenerator.generate(), book1, BookStatus.AVAILABLE, "Shelf-A1");
        BookItem item2 = new BookItem(IdGenerator.generate(), book2, BookStatus.AVAILABLE, "Shelf-B2");
        bookItemRepo.save(item1);
        bookItemRepo.save(item2);

        // Users
        BaseUser student = new Student(IdGenerator.generate(), "Pawan", "pawan@example.com");
        BaseUser faculty = new Faculty(IdGenerator.generate(), "Dr. Smith", "smith@example.com");
        BaseUser guest = new Guest(IdGenerator.generate(), "Alice", "alice@example.com");
        userRepo.save(student);
        userRepo.save(faculty);
        userRepo.save(guest);

        // Checkout book
        IO.println("\n--- Checkout Book ---");
        Loan loan1 = circulationService.checkout(student.getId(), item1.getId());
        IO.println("Loan created: " + loan1);

        // Return book
        IO.println("\n--- Return Book ---");
        double fine = circulationService.returnBook(item1.getId());
        IO.println("Book returned. Fine: " + fine);

        // Renew book (checkout again first)
        IO.println("\n--- Renew Book ---");
        Loan loan2 = circulationService.checkout(faculty.getId(), item2.getId());
        IO.println("Loan before renewal: " + loan2);
        circulationService.renew(item2.getId());
        List<Loan> facultyLoans = circulationService.getLoansForUser(faculty.getId());
        IO.println("Faculty loans after renewal: " + facultyLoans);

        // Search books
        IO.println("\n--- Search Books ---");
        List<Book> searchResult = catalogService.searchByTitle("clean");
        IO.println("Search result: " + searchResult);
    }
}

