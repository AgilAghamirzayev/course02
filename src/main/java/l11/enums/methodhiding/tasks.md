# Lesson 11 Practical Tasks - Enums, Overriding, and Method Hiding

## Objective

The goal of this assignment is to practice Java `enum` design, method overriding, static method hiding, and related OOP behavior in inheritance hierarchies.

By completing these tasks, students will understand compile-time vs runtime resolution and design cleaner, type-safe code with enums.

## Project Structure Requirement

Unlike Lesson 10, each task must have its own package, and you may split code into multiple classes per task.

```text
src/main/java/l11/homework/task01/
src/main/java/l11/homework/task02/
...
src/main/java/l11/homework/task12/
```

Suggested runnable class naming:

```text
Task01Main.java
Task02Main.java
...
Task12Main.java
```

## Task 1 - Easy Level (Basic Enum Intro)

### Instructions

1. Create enum `Day` with 7 constants.
2. Create class `Task01Main` to print all enum values using `values()`.
3. Print `name()` and `ordinal()` for each.

### Expected Result

- Correct enum declaration
- Iteration over enum constants
- Basic metadata usage (`name`, `ordinal`)

### Deliverable

Package `l11.homework.task01` with runnable `Task01Main`.

## Task 2 - Easy Level (Enum With Field + Constructor)

### Instructions

1. Create enum `TrafficLight` with constants `RED`, `YELLOW`, `GREEN`.
2. Add field `seconds` to each constant via enum constructor.
3. In `Task02Main`, print each light with its duration.

### Expected Result

- Enum constants with custom data
- Constructor-based value assignment
- Clean formatted output

### Deliverable

Package `l11.homework.task02` with enum + runnable `Task02Main`.

## Task 3 - Easy Level (Enum Parsing and Validation)

### Instructions

1. Create enum `OrderStatus` with at least 5 statuses.
2. In `Task03Main`, simulate user input strings.
3. Convert with `valueOf` safely (handle invalid input with `try/catch`).

### Expected Result

- Practical `valueOf` usage
- Graceful invalid input handling
- Clear validation flow

### Deliverable

Package `l11.homework.task03` with runnable `Task03Main`.

## Task 4 - Easy Level (Instance Method Overriding)

### Instructions

1. Create class `Vehicle` with method `move()`.
2. Create subclasses `Car` and `Bike` overriding `move()`.
3. In `Task04Main`, store objects in `Vehicle[]` and call `move()`.

### Expected Result

- Correct runtime polymorphism
- Proper method overriding
- Base reference, subtype behavior

### Deliverable

Package `l11.homework.task04` with multiple classes and runnable `Task04Main`.

## Task 5 - Medium Level (Static Method Hiding Basics)

### Instructions

1. Create class `Parent` with static method `whoAmI()`.
2. Create class `Child` with static method `whoAmI()` (same signature).
3. In `Task05Main`, call methods with:
   - `Parent.whoAmI()`
   - `Child.whoAmI()`
   - reference case: `Parent ref = new Child(); ref.whoAmI();`
4. Add comments explaining why output differs from overriding.

### Expected Result

- Correct method hiding demonstration
- Compile-time binding awareness
- Clear distinction from instance overriding

### Deliverable

Package `l11.homework.task05` with runnable `Task05Main`.

## Task 6 - Medium Level (Overriding + Hiding Together)

### Instructions

1. In base class `Account`, define:
   - static method `bankName()`
   - instance method `info()`
2. In subclass `PremiumAccount`, hide `bankName()` and override `info()`.
3. In `Task06Main`, demonstrate both method calls using base and child references.

### Expected Result

- One example showing both behaviors in same hierarchy
- Correct output reasoning for static vs instance methods
- Better conceptual separation

### Deliverable

Package `l11.homework.task06` with runnable `Task06Main`.

## Task 7 - Medium Level (Enum With Behavior per Constant)

### Instructions

1. Create enum `Operation` with constants `ADD`, `SUBTRACT`, `MULTIPLY`, `DIVIDE`.
2. Each constant overrides abstract method `apply(double a, double b)`.
3. In `Task07Main`, run sample calculations using all constants.

### Expected Result

- Constant-specific method implementation
- Enum as strategy-like behavior holder
- Cleaner branch-free design

### Deliverable

Package `l11.homework.task07` with runnable `Task07Main`.

## Task 8 - Medium Level (Enum + Switch Expression)

### Instructions

1. Create enum `MembershipLevel` (`BRONZE`, `SILVER`, `GOLD`, `PLATINUM`).
2. Create class `DiscountService` with method `discountPercent(MembershipLevel level)` using switch expression.
3. In `Task08Main`, print discount for each level.

### Expected Result

- Correct enum + switch usage
- Exhaustive handling of enum values
- Readable business-rule mapping

### Deliverable

Package `l11.homework.task08` with `DiscountService` and runnable `Task08Main`.

## Task 9 - Hard Level (Mini Role-Based Access via Enum)

### Instructions

1. Create enum `Role` with permissions field (for example, `canDelete`, `canEdit`).
2. Create class `User` (name + role).
3. Create `AccessChecker` class to validate allowed actions.
4. In `Task09Main`, test multiple users and actions.

### Expected Result

- Type-safe role modeling with enum
- Permission logic separated from main
- Realistic domain simulation

### Deliverable

Package `l11.homework.task09` with multiple classes and runnable `Task09Main`.

## Task 10 - Hard Level (Method Hiding Pitfall Analyzer)

### Instructions

1. Create hierarchy `BaseLogger` and `FileLogger`.
2. Add static method `format()` in both classes (hiding case).
3. Add instance method `log()` overriding in child.
4. In `Task10Main`, call both static and instance methods through different reference types.
5. Print a short analysis section explaining each output.

### Expected Result

- Strong understanding of hiding pitfalls
- Practical difference between static and instance dispatch
- Developer-oriented explanation in output/comments

### Deliverable

Package `l11.homework.task10` with runnable `Task10Main`.

## Task 11 - Hard Level (Enum-Driven State Machine)

### Instructions

1. Create enum `TicketState` with transitions:
   - `OPEN -> IN_PROGRESS -> RESOLVED -> CLOSED`
2. Add method `next()` inside enum.
3. Create class `Ticket` holding current state and method `advance()`.
4. In `Task11Main`, simulate full lifecycle and prevent illegal transition from `CLOSED`.

### Expected Result

- Enum-centered state transition logic
- Reduced invalid state handling risk
- Clear lifecycle simulation

### Deliverable

Package `l11.homework.task11` with runnable `Task11Main`.

## Task 12 - Hard Level (Combined Capstone: Enum + Overriding + Hiding)

### Instructions

1. Build mini notification app with:
   - enum `ChannelType` (`EMAIL`, `SMS`, `PUSH`)
   - abstract class `Notifier` with instance method `send()`
   - subclasses `EmailNotifier`, `SmsNotifier`, `PushNotifier` overriding `send()`
2. Add static method `providerName()` in base class and hide it in at least one subclass.
3. Create `NotificationFactory` returning notifier by `ChannelType`.
4. In `Task12Main`, run all channel scenarios and show:
   - runtime overriding for `send()`
   - compile-time binding for static `providerName()`

### Expected Result

- End-to-end demonstration of lesson concepts
- Correct combination of enum routing + polymorphism + hiding
- Multi-class architecture with clear responsibilities

### Deliverable

Package `l11.homework.task12` with multiple classes and runnable `Task12Main`.

## Final Submission

Submit all 12 task packages and confirm each `TaskXXMain` class runs from `main`.
