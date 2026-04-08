# Lesson 10 Practical Tasks - Polymorphism, Abstraction, Interfaces, and Testability

## Objective

The goal of this assignment is to apply advanced OOP design in Java using polymorphism, abstraction, interfaces, composition, and test-friendly architecture.

By completing these tasks, students will move from class-level coding toward maintainable and extensible software design.

## Project Structure Requirement

Create one package and 12 task classes:

```text
src/main/java/l10/homework/
```

Suggested class naming:

```text
Task01EasyPolymorphismIntro.java
Task02EasyOverloadingPractice.java
...
Task12HardInterfaceDrivenMiniApp.java
```

## Task 1 - Easy Level (Runtime Polymorphism Intro)

### Instructions

1. Create base class `Animal` with method `speak()`.
2. Create subclasses `Dog` and `Cat` that override `speak()`.
3. In `main`, store both in an `Animal[]`.
4. Loop through and call `speak()` on each object.

### Expected Result

- Correct method overriding
- Runtime dispatch via base-type reference
- Clean polymorphic loop

### Deliverable

A Java class named `Task01EasyPolymorphismIntro` with runnable `main`.

## Task 2 - Easy Level (Method Overloading Practice)

### Instructions

1. Create `Calculator` with overloaded `sum` methods:
   - `sum(int a, int b)`
   - `sum(double a, double b)`
   - `sum(int a, int b, int c)`
2. Call each overload in `main`.
3. Print outputs with clear labels.

### Expected Result

- Correct overloading signatures
- Compile-time method resolution
- Readable demonstration output

### Deliverable

A Java class named `Task02EasyOverloadingPractice` with runnable `main`.

## Task 3 - Easy Level (`instanceof` Type Branching)

### Instructions

1. Create interface `Notification`.
2. Add classes `EmailNotification` and `SmsNotification`.
3. Build `Notification[]` with mixed objects.
4. Use `instanceof` checks to print channel-specific labels.

### Expected Result

- Correct `instanceof` usage on mixed objects
- Safe subtype branching
- Understand when type checks are needed

### Deliverable

A Java class named `Task03EasyInstanceofBranching` with runnable `main`.

## Task 4 - Easy Level (Abstract Class Basics)

### Instructions

1. Create abstract class `Shape` with abstract method `double area()`.
2. Add shared field `name` and concrete method `printName()`.
3. Implement subclasses `Circle` and `Rectangle`.
4. In `main`, create objects and print names + areas.

### Expected Result

- Proper abstract class design
- Shared logic plus abstract behavior
- Subclass-specific implementations

### Deliverable

A Java class named `Task04EasyAbstractShape` with runnable `main`.

## Task 5 - Medium Level (Interface Contract with Multiple Implementations)

### Instructions

1. Define interface `PaymentGateway` with `boolean charge(double amount)`.
2. Implement:
   - `CardGateway`
   - `CashGateway`
3. Create `CheckoutService` that depends on `PaymentGateway`.
4. Run checkout flow with both implementations.

### Expected Result

- Interface-driven service dependency
- Swappable implementations without service rewrite
- Clear separation of contract vs implementation

### Deliverable

A Java class named `Task05MediumPaymentGateway` with runnable `main`.

## Task 6 - Medium Level (Abstract Class vs Interface Decision Lab)

### Instructions

1. Create interface `ReportExporter` with method `export(String data)`.
2. Create abstract class `BaseExporter` with shared field `formatName`.
3. Implement two exporters (`CsvExporter`, `JsonExporter`) extending `BaseExporter` and implementing `ReportExporter`.
4. Print how shared base behavior and interface contract work together.

### Expected Result

- Correct combined use of abstract class and interface
- Reusable base logic
- Clear architecture reasoning in code

### Deliverable

A Java class named `Task06MediumExporterDesign` with runnable `main`.

## Task 7 - Medium Level (Composition Over Inheritance Refactor)

### Instructions

1. Start with a naive design where `SmartPrinter` extends `Printer`.
2. Refactor to composition:
   - Interface `PrintEngine`
   - Implementations `InkjetEngine` and `LaserEngine`
   - `Printer` has `PrintEngine` field
3. Demonstrate changing engine without changing `Printer` class logic.

### Expected Result

- Working composition-based model
- Better flexibility than rigid subclassing
- Clear "has-a" relationship

### Deliverable

A Java class named `Task07MediumCompositionRefactor` with runnable `main`.

## Task 8 - Medium Level (Strategy Pattern with Discount Policies)

### Instructions

1. Create interface `DiscountPolicy` with `double apply(double amount)`.
2. Implement:
   - `NoDiscount`
   - `PercentDiscount`
   - `ThresholdDiscount`
3. Create `OrderCalculator` that uses a `DiscountPolicy`.
4. Test total calculation with different strategies.

### Expected Result

- Strong strategy-style polymorphism
- Replaceable pricing behavior
- Cleaner business logic separation

### Deliverable

A Java class named `Task08MediumDiscountStrategy` with runnable `main`.

## Task 9 - Hard Level (Testable Service via Dependency Injection)

### Instructions

1. Define interface `MessageSender` with `send(String to, String text)`.
2. Implement `RealMessageSender`.
3. Implement `NotificationService` that receives `MessageSender` in constructor.
4. Create `FakeMessageSender` for test simulation (store sent messages in array/list).
5. In `main`, validate that fake sender captured expected messages.

### Expected Result

- Constructor-based dependency injection
- Easy behavior verification using fake dependency
- Deterministic service testing flow

### Deliverable

A Java class named `Task09HardTestableNotificationService` with runnable `main`.

## Task 10 - Hard Level (Polymorphic Repository Layer)

### Instructions

1. Create interface `UserRepository` with methods:
   - `void save(User user)`
   - `User findById(int id)`
2. Implement:
   - `InMemoryUserRepository`
   - `ArrayUserRepository`
3. Build `UserService` that depends only on `UserRepository`.
4. Use both repository implementations in separate runs.

### Expected Result

- Low-coupled service-to-data access boundary
- Swappable repository implementations
- Practical interface architecture

### Deliverable

A Java class named `Task10HardRepositoryPolymorphism` with runnable `main`.

## Task 11 - Hard Level (Command Processor with Interface Composition)

### Instructions

1. Define interface `Command` with methods:
   - `String name()`
   - `void execute()`
2. Create commands:
   - `StartCommand`
   - `StopCommand`
   - `StatusCommand`
3. Build `CommandProcessor` that stores `Command[]` and executes by command name.
4. In `main`, simulate multiple command calls and unknown command handling.

### Expected Result

- Composition-based command architecture
- Polymorphic execution flow
- Better scalability for adding new commands

### Deliverable

A Java class named `Task11HardCommandProcessor` with runnable `main`.

## Task 12 - Hard Level (Interface-Driven Mini Application)

### Instructions

1. Build a mini console app for order processing.
2. Required interfaces:
   - `PricingPolicy`
   - `PaymentGateway`
   - `OrderPrinter`
3. Provide at least two implementations for one interface (example: two pricing policies).
4. Create `OrderAppService` composed from these interfaces via constructor injection.
5. In `main`, run at least 3 order scenarios and print results.

### Expected Result

- End-to-end interface-based architecture
- Composition and polymorphism in one complete flow
- Design ready for extension and testing

### Deliverable

A Java class named `Task12HardInterfaceDrivenMiniApp` with runnable `main`.

## Final Submission

Submit the 12 Java classes and confirm each class runs from `main`.
