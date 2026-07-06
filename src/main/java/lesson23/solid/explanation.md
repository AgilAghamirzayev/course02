# SOLID Principles

SOLID is a set of five object-oriented design principles that help us write code that is easier to understand, change, test, and extend.

The main idea is simple:

> Good code should be easy to change without breaking unrelated parts of the system.

SOLID is especially useful in Java because Java projects often grow into many classes, services, interfaces, and business rules.

## 1. S - Single Responsibility Principle

### Meaning

A class should have only one reason to change.

In simple words, one class should focus on one job.

If a class does too many things, changing one feature can accidentally break another feature.

### Real-world example

Think about a restaurant.

A chef cooks food.
A waiter serves customers.
A cashier handles payment.

If one person does all three jobs, the restaurant becomes harder to manage. If payment rules change, the chef should not be affected. If the menu changes, the cashier should not be affected.

Software should be organized the same way.

### Bad example

```java
class Invoice {
    public void calculateTotal() {
        // Calculates invoice total
    }

    public void printInvoice() {
        // Prints invoice
    }

    public void saveToDatabase() {
        // Saves invoice to database
    }
}
```

This class has three responsibilities:

- Calculating invoice total
- Printing invoice
- Saving invoice

So it has three reasons to change.

If printing format changes, this class changes.
If database logic changes, this class changes.
If tax calculation changes, this class changes.

### Better example

```java
class Invoice {
    public void calculateTotal() {
        // Calculates invoice total
    }
}

class InvoicePrinter {
    public void print(Invoice invoice) {
        // Prints invoice
    }
}

class InvoiceRepository {
    public void save(Invoice invoice) {
        // Saves invoice to database
    }
}
```

Now each class has one clear job.

### When to use this principle

Use this principle when a class starts becoming too large or has methods that belong to different topics.

For example, if a `UserService` validates users, sends emails, saves files, logs activity, and generates reports, it is probably doing too much.

## 2. O - Open/Closed Principle

### Meaning

Software entities should be open for extension but closed for modification.

In simple words, you should be able to add new behavior without changing existing working code.

This reduces the chance of breaking old functionality.

### Real-world example

Think about a phone charger.

You can plug different devices into it if they support the same charging standard. The charger does not need to be rebuilt every time a new phone is released.

The charger is closed for modification, but open for extension through compatible devices.

### Bad example

```java
class PaymentProcessor {
    public void pay(String paymentType) {
        if (paymentType.equals("CARD")) {
            System.out.println("Paid by card");
        } else if (paymentType.equals("CASH")) {
            System.out.println("Paid by cash");
        } else if (paymentType.equals("PAYPAL")) {
            System.out.println("Paid by PayPal");
        }
    }
}
```

If we add Apple Pay, Google Pay, or crypto payment, we must change this class again.

That means old code is constantly being modified.

### Better example

```java
interface PaymentMethod {
    void pay();
}

class CardPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Paid by card");
    }
}

class CashPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Paid by cash");
    }
}

class PayPalPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Paid by PayPal");
    }
}

class PaymentProcessor {
    public void process(PaymentMethod paymentMethod) {
        paymentMethod.pay();
    }
}
```

Now if we need Apple Pay, we add a new class:

```java
class ApplePayPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Paid by Apple Pay");
    }
}
```

We do not need to change `PaymentProcessor`.

### When to use this principle

Use this principle when you see many `if`, `else if`, or `switch` statements that check types and perform different behavior.

Common examples:

- Payment methods
- Notification types
- Discount strategies
- Report formats
- Delivery methods

## 3. L - Liskov Substitution Principle

### Meaning

Objects of a child class should be usable anywhere objects of the parent class are expected, without breaking the program.

In simple words, a subclass should behave like a proper version of its parent.

If a child class changes the expected behavior of the parent class, the design is wrong.

### Real-world example

Imagine a company gives employees ID cards.

Any employee ID card should allow the employee to enter the office.

If a manager's ID card works but an intern's ID card crashes the entry system, then the intern card is not a proper substitute for an employee ID card.

### Bad example

```java
class Bird {
    public void fly() {
        System.out.println("Flying");
    }
}

class Sparrow extends Bird {
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly");
    }
}
```

The problem is that not all birds can fly.

If some code expects any `Bird` to fly, `Penguin` breaks that expectation.

```java
public void makeBirdFly(Bird bird) {
    bird.fly();
}
```

This works for `Sparrow`, but fails for `Penguin`.

### Better example

```java
interface Bird {
    void eat();
}

interface FlyingBird extends Bird {
    void fly();
}

class Sparrow implements FlyingBird {
    public void eat() {
        System.out.println("Sparrow is eating");
    }

    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin implements Bird {
    public void eat() {
        System.out.println("Penguin is eating");
    }
}
```

Now only birds that can fly implement `FlyingBird`.

```java
public void makeBirdFly(FlyingBird bird) {
    bird.fly();
}
```

This method cannot accidentally receive a `Penguin`.

### When to use this principle

Use this principle when inheritance creates strange or impossible behavior.

Warning signs:

- A subclass throws `UnsupportedOperationException`
- A subclass overrides a method but leaves it empty
- A subclass changes the meaning of the parent method
- You need many type checks like `if (object instanceof SomeChildClass)`

## 4. I - Interface Segregation Principle

### Meaning

A class should not be forced to implement methods it does not need.

In simple words, prefer small, specific interfaces instead of one large interface.

### Real-world example

Think about a multifunction machine.

Some machines can print, scan, and fax.
Some simple printers can only print.

It would be wrong to force every printer to support scanning and faxing.

Software interfaces should work the same way.

### Bad example

```java
interface Machine {
    void print();
    void scan();
    void fax();
}

class SimplePrinter implements Machine {
    public void print() {
        System.out.println("Printing");
    }

    public void scan() {
        throw new UnsupportedOperationException("Scan not supported");
    }

    public void fax() {
        throw new UnsupportedOperationException("Fax not supported");
    }
}
```

`SimplePrinter` is forced to implement methods it cannot actually support.

### Better example

```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class SimplePrinter implements Printer {
    public void print() {
        System.out.println("Printing");
    }
}

class OfficeMachine implements Printer, Scanner, Fax {
    public void print() {
        System.out.println("Printing");
    }

    public void scan() {
        System.out.println("Scanning");
    }

    public void fax() {
        System.out.println("Faxing");
    }
}
```

Now each class implements only the behavior it actually supports.

### When to use this principle

Use this principle when an interface becomes too large or when implementing classes contain empty methods or unsupported methods.

Common examples:

- `Readable`, `Writable`, and `Deletable` instead of one huge `FileOperations`
- `EmailSender` and `SmsSender` instead of one huge `NotificationService`
- `Printable`, `Scannable`, and `Faxable` instead of one huge `Machine`

## 5. D - Dependency Inversion Principle

### Meaning

High-level classes should not depend directly on low-level classes. Both should depend on abstractions.

In simple words, business logic should depend on interfaces, not concrete implementation classes.

This makes code easier to test, replace, and extend.

### Real-world example

Think about a wall socket.

A laptop does not care which power plant produced the electricity. It only depends on the socket standard.

The power plant can change, but the laptop still works because it depends on an abstraction: the socket.

### Bad example

```java
class MySqlUserRepository {
    public void save(String username) {
        System.out.println("Saving userEntity to MySQL: " + username);
    }
}

class UserService {
    private MySqlUserRepository repository = new MySqlUserRepository();

    public void register(String username) {
        repository.save(username);
    }
}
```

`UserService` depends directly on `MySqlUserRepository`.

If we want to use PostgreSQL, MongoDB, or an in-memory repository for tests, we must change `UserService`.

### Better example

```java
interface UserRepository {
    void save(String username);
}

class MySqlUserRepository implements UserRepository {
    public void save(String username) {
        System.out.println("Saving userEntity to MySQL: " + username);
    }
}

class PostgreSqlUserRepository implements UserRepository {
    public void save(String username) {
        System.out.println("Saving userEntity to PostgreSQL: " + username);
    }
}

class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void register(String username) {
        repository.save(username);
    }
}
```

Now `UserService` depends on the `UserRepository` interface, not a concrete database class.

Usage:

```java
UserRepository repository = new MySqlUserRepository();
UserService userService = new UserService(repository);

userService.register("Ali");
```

For testing:

```java
class InMemoryUserRepository implements UserRepository {
    public void save(String username) {
        System.out.println("Saving userEntity in memory: " + username);
    }
}
```

Now tests can use `InMemoryUserRepository` without touching production database code.

### When to use this principle

Use this principle when a service creates its own dependencies using `new`.

Bad sign:

```java
class OrderService {
    private EmailSender emailSender = new EmailSender();
}
```

Better:

```java
class OrderService {
    private final NotificationSender notificationSender;

    public OrderService(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }
}
```

This approach is also the foundation of dependency injection frameworks like Spring.

## How SOLID Principles Work Together

SOLID principles are connected.

For example, imagine an online shopping application:

- Single Responsibility: `OrderService` creates orders, `PaymentService` handles payments, `EmailService` sends emails.
- Open/Closed: New payment methods can be added without changing existing payment processing code.
- Liskov Substitution: Any class implementing `PaymentMethod` must behave like a real payment method.
- Interface Segregation: `EmailSender`, `SmsSender`, and `PushNotificationSender` can be separate small interfaces.
- Dependency Inversion: `OrderService` depends on a `PaymentMethod` interface, not directly on `CardPayment`.

Together, these principles make the system easier to grow.

## Simple Memory Trick

SOLID means:

- S: One class, one responsibility
- O: Add new behavior without changing old code
- L: Child classes must correctly replace parent classes
- I: Small interfaces are better than huge interfaces
- D: Depend on interfaces, not concrete classes

## Final Practical Advice

Do not apply SOLID blindly.

The goal is not to create many interfaces and classes for every small problem. The goal is to make code easier to change.

Use SOLID when:

- A class is doing too many things
- You keep modifying old code to add new features
- Inheritance creates strange behavior
- Interfaces force classes to implement useless methods
- Code is hard to test because it directly creates concrete dependencies

Good SOLID code usually feels simple:

- Classes are small
- Responsibilities are clear
- New features are easy to add
- Tests are easier to write
- Changes do not break unrelated behavior
