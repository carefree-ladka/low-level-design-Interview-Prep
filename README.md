# Low-Level Design (LLD) Complete Learning Roadmap

This comprehensive roadmap provides a structured approach to mastering Low-Level Design, essential for system design interviews and building robust, maintainable software systems.

## What is Low-Level Design?
Low-Level Design translates High-Level Design abstractions into concrete, implementable code structures, focusing on how individual components are built rather than what the overall system architecture looks like. LLD operates at the module and class level, defining entities, relationships, interfaces, and design patterns that make code modular, extensible, and maintainable.

## OOP Fundamentals
- **Classes and Objects** - Blueprint vs instance concepts, state and behavior modeling
- **Enums** - Type-safe constants and their applications
- **Interfaces** - Contract definition and loose coupling
- **Encapsulation** - Data hiding and access control mechanisms
- **Abstraction** - Hiding implementation complexity behind clean interfaces
- **Inheritance** - Code reusability through parent-child relationships
- **Polymorphism** - Runtime behavior modification and method overriding

## Class Relationships

- **Association** - Basic relationships between classes without dependency
- **Aggregation** - "Has-a" relationships where parts can exist independently
- **Composition** - Strong "part-of" relationships with lifecycle dependency
- **Dependency** - Usage relationships and coupling management

## Design Principles

- **DRY Principle** - Avoiding code duplication and promoting reusability
- **KISS Principle** - Maintaining simplicity in design and implementation
- **YAGNI Principle** - Building only what's currently needed
- **Law of Demeter** - Minimizing object communication chains
- **Separation of Concerns** - Dividing functionality into distinct modules
- **Coupling and Cohesion** - Managing dependencies and module focus

## SOLID Principles

- **Single Responsibility Principle** - One reason to change per class
- **Open/Closed Principle** - Open for extension, closed for modification
- **Liskov Substitution Principle** - Proper inheritance hierarchy design
- **Interface Segregation Principle** - Client-specific interface design
- **Dependency Inversion Principle** - Depend on abstractions, not concretions


## UML Diagrams

- **Class Diagram** - Visual representation of system structure with classes, attributes, and relationships
- **Use Case Diagram** - System functionality from user perspective
- **Sequence Diagram** - Object interactions over time

## Design Patterns

**Creational Patterns**

- **Singleton** - Single instance management
- **Factory Method** - Object creation abstraction
- **Abstract Factory** - Family of related objects
- **Builder** - Complex object construction[^1_5]
- **Prototype** - Object cloning mechanism

**Structural Patterns**

- **Adapter** - Interface compatibility
- **Facade** - Simplified interface to complex subsystems
- **Decorator** - Dynamic behavior addition
- **Composite** - Tree structure representation
- **Proxy** - Controlled access to objects
- **Bridge** - Abstraction and implementation separation
- **Flyweight** - Memory optimization through sharing

**Behavioral Patterns**

- **Iterator** - Sequential element access
- **Observer** - One-to-many dependency notification
- **Strategy** - Algorithm family encapsulation
- **Command** - Request encapsulation as objects
- **State** - Behavior change based on internal state
- **Template Method** - Algorithm skeleton definition
- **Visitor** - Operations on object structures
- **Mediator** - Centralized object communication
- **Memento** - State capture and restoration
- **Chain of Responsibility** - Request handling chain

## Interview Preparation Skills

Interviewers assess several key capabilities during LLD interviews:

- **Problem Decomposition** - Breaking complex systems into manageable components
- **OOP Principle Application** - Proper use of encapsulation, inheritance, and polymorphism
- **SOLID Principle Implementation** - Creating robust, maintainable designs
- **Design Pattern Selection** - Choosing appropriate patterns for specific problems
- **Code Clarity** - Writing readable, well-structured code with meaningful names
- **Trade-off Analysis** - Understanding and articulating design decisions

# System Design Steps

## 1. Requirements Clarification

**Functional:**  
- What should the system do?
**Non-functional:**  
- Scale, performance, constraints
**Scope boundaries:**  
- What's included/excluded

## 2. Core Entities & Relationships

- Identify main classes (nouns from requirements)  
- Define relationships: inheritance vs composition  
- Keep it simple - avoid over-engineering

## 3. Class Design

- Key attributes per class  
- Primary responsibilities  
- Apply encapsulation & OOP principles

## 4. Interface Definition

- Core operations/methods (e.g., `park()`, `unpark()`)  
- Method signatures with clear contracts

## 5. Implementation (Skeleton Code)

- Write concise Java classes  
- Focus on structure, not full implementation  
- Show OOP principles in action

## 6. Handle Edge Cases & Extensions

- Common failure scenarios  
- Quick mention of design patterns if relevant  
- Scalability considerations (if time permits)

---

# Frequently Asked LLD Questions in Java

Below is a list of commonly asked low-level design (LLD) problems for Java interviews, roughly ordered by frequency.

## 1. High-Frequency Questions
- **Snake & Ladder Game** — [Code Repo](https://github.com/carefree-ladka/low-level-design-Interview-Prep/tree/main/src/snakeandladder)  
- **Tic Tac Toe** (including max 3 token variant)  
- **Parking Lot System** — [Code Repo](https://github.com/carefree-ladka/low-level-design-Interview-Prep/tree/main/src/parkinglot)  
- **Elevator System** — [Code Repo](https://github.com/carefree-ladka/low-level-design-Interview-Prep/tree/main/src/elevatorsystem)  
- **Library Management System** — [Code Repo](https://github.com/carefree-ladka/low-level-design-Interview-Prep/tree/main/src/bookslibrary)  
- **ATM System**

## 2. Medium-Frequency Questions
- **Messaging / Chat System**
- **Nested Comments System**
- **Shopping Cart / Checkout System**
- **Inventory Management System**
- **Order Management System**
- **Cab / Ride Hailing System**
- **Payment Gateway System**
- **Wallet / Banking System**

## 3. Low-Frequency / Specialized Questions
- **Chess / Checkers**
- **Video Streaming System**
- **Itinerary / Travel Planner**
- **URL Shortener**
- **Task Scheduler / Job Queue**
- **Circular Buffer / Producer-Consumer System**
- **File System** (simplified version)
- **Hotel Room Booking System**
- **Restaurant Table Reservation System**
- **Social Media Feed System** (like Twitter timeline)
- **Notification / Alert System**






