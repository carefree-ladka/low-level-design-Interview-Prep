# Library Management System – Low-Level Design (LLD)

## Overview

This project demonstrates a **Library Management System** implemented in Java following object-oriented design principles. It supports operations like:

- Book catalog management
- Book checkout, return, and renewal
- User management (Student, Faculty, Guest)
- Fine calculation for overdue books
- Notifications on library activities

The system is designed to be **extensible, modular, and maintainable**, following clean architecture principles.

---

## Features Implemented

- ✅ Add, search, and manage books and book items
- ✅ Support multiple user types with different borrowing limits
- ✅ Check out and return books
- ✅ Automatic fine calculation using a strategy pattern
- ✅ Renew books and track due dates
- ✅ Simple notification system
- ✅ In-memory repositories for storage (can be replaced with DB later)

---

## Folder Structure

```
bookslibrary/
├── app/                      # Main entry point
│   └── Main.java
├── enums/                    # Enumerations
│   ├── BookStatus.java
│   └── UserType.java
├── exception/                # Custom exceptions
│   ├── BookNotAvailableException.java
│   ├── LibraryException.java
│   ├── MaxBooksIssuedException.java
│   └── UserNotFoundException.java
├── factory/                  # Utility classes
│   └── IdGenerator.java
├── model/                    # Core entities
│   ├── Book.java
│   ├── BookItem.java
│   ├── Loan.java
│   └── user/
│       ├── BaseUser.java
│       ├── Student.java
│       ├── Faculty.java
│       └── Guest.java
├── repository/               # Repository interfaces
│   ├── IBookRepository.java
│   ├── IBookItemRepository.java
│   ├── IUserRepository.java
│   ├── ILoanRepository.java
│   └── impl/                 # Repository implementations
│       ├── InMemoryBookRepository.java
│       ├── InMemoryBookItemRepository.java
│       ├── InMemoryUserRepository.java
│       └── InMemoryLoanRepository.java
├── service/                  # Service interfaces
│   ├── ICatalogService.java
│   ├── ICirculationService.java
│   ├── INotificationService.java
│   └── impl/                 # Service implementations
│       ├── CatalogService.java
│       ├── CirculationService.java
│       └── NotificationService.java
└── strategy/                 # Strategy interfaces
    ├── IFineCalculationStrategy.java
    └── impl/                 # Strategy implementations
        └── DefaultFineStrategy.java
```

---

## Key Design Decisions

### 1. Object-Oriented Principles

- **Encapsulation**: All entities have private fields with getters/setters
- **Abstraction**: Abstract class `BaseUser` and interfaces (`I*`) used for services and repositories
- **Inheritance**: `Student`, `Faculty`, and `Guest` inherit from `BaseUser`
- **Polymorphism**: Fine calculation strategy can be swapped without changing service logic

### 2. Design Patterns

- **Strategy Pattern**: Used for flexible fine calculation (`IFineCalculationStrategy`, `DefaultFineStrategy`)
- **Repository Pattern**: Abstracts storage, allows easy replacement of in-memory data with a database
- **Factory Pattern**: `IdGenerator` for unique ID generation
- **Dependency Inversion Principle**: Services depend on interfaces, not concrete implementations

### 3. Interface + Implementation Pattern

- **Clear Separation**: Interfaces are defined in `repository/`, `service/`, and `strategy/` packages
- **Implementation Isolation**: Concrete implementations reside in `impl/` sub-packages
- **Benefits**:
    - Easy to swap implementations without changing dependent code
    - Supports unit testing with mock implementations
    - Enables multiple implementations (e.g., InMemory, MySQL, MongoDB)
    - Follows SOLID principles, especially Open/Closed and Dependency Inversion

### 4. Extensibility

- **Adding a new user type**: Extend `BaseUser` and define borrowing rules
- **Adding a new fine strategy**: Implement `IFineCalculationStrategy`
- **Replacing in-memory repositories**: Implement repository interfaces using DB (MySQL, MongoDB, etc.)

### 5. Error Handling

Custom exceptions used for:
- Book not available
- User not found
- Max books issued

---

## How to Run

1. Clone the repository
2. Open in IntelliJ IDEA or your preferred IDE
3. Build the project using Java 11+
4. Run `Main.java` in the `app` package
5. Observe output for book checkout, return, renewals, and search functionality

---

## Technologies & Tools

- **Language**: Java 11+
- **Build Tool**: Any Java IDE (IntelliJ IDEA, Eclipse)
- **Testing**: Manual console testing
- **Data Storage**: In-memory collections (Map, List)

---

## Key Takeaways

✨ Demonstrates a clean LLD approach suitable for interviews

✨ Shows OOP design, interfaces, abstract classes, and design patterns in practice

✨ Fully modular, making it easy to extend or integrate with databases or front-end apps

✨ Interface-driven design enables easy testing and implementation swapping

---

## Future Enhancements

- [ ] Add database integration (MySQL/PostgreSQL)
- [ ] Implement REST API layer
- [ ] Add comprehensive unit tests
- [ ] Create UML class diagrams
- [ ] Add search with filters (author, genre, publication year)
- [ ] Implement reservation system for books
- [ ] Add email/SMS notification service

---

## License

This project is created for educational purposes and interview preparation.

---

## Author

Created as a demonstration of Low-Level Design principles in Java.