# Lesson 10: Polymorphism, Abstraction, Interfaces, and Design for Testability

This lesson moves from basic class design into scalable OOP architecture.
You will learn how to replace rigid class dependencies with interface-driven design, apply polymorphism correctly, and build code that is easier to test and maintain.

## In-class coverage:

- [ ] Polymorphism fundamentals: `instanceof`, method overloading, and method overriding
- [ ] Abstract classes vs interfaces: selection criteria
- [ ] Interface-based architecture and loose coupling
- [ ] Composition over inheritance principle
- [ ] Practical interface-driven implementation exercise

## Learning Objectives

By the end of this lesson, students will be able to:

- Explain compile-time and runtime polymorphism in Java
- Use method overloading and overriding in appropriate scenarios
- Use `instanceof` safely to inspect and branch by runtime type
- Decide between abstract class and interface based on design goals
- Build low-coupled systems with interface-based dependencies
- Prefer composition over inheritance for flexible object behavior
- Write code that is easy to unit test via dependency substitution

## 1. Polymorphism Fundamentals

Polymorphism means "one interface, many implementations."
In Java, this appears in two common forms.

### 1.1 Method Overloading (Compile-Time Polymorphism)

Overloading means same method name, different parameters.

```java
class PriceCalculator {
    double total(double price, int qty) {
        return price * qty;
    }

    double total(double price, int qty, double discountRate) {
        return price * qty * (1 - discountRate);
    }
}
```

The compiler chooses which method to call based on argument types/count.

### 1.2 Method Overriding (Runtime Polymorphism)

Overriding means a subclass provides its own implementation.

```java
class Animal {
    void speak() {
        System.out.println("Unknown sound");
    }
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Woof");
    }
}
```

Runtime type decides behavior:

```java
Animal a = new Dog();
a.speak(); // Woof
```

### 1.3 Using `instanceof` Responsibly

`instanceof` checks runtime type, useful when behavior depends on exact subtype.

```java
if (animal instanceof Dog) {
    System.out.println("Dog-specific branch");
}
```

Guideline:

- Use `instanceof` when integrating with mixed object collections
- If frequent `instanceof` chains appear, consider moving behavior into polymorphic methods

## 2. Abstract Class vs Interface

Both support abstraction, but with different tradeoffs.

### 2.1 Use Abstract Class When

- Subclasses share common state (fields)
- Subclasses share partial implementation
- You want protected helper methods and template workflow

### 2.2 Use Interface When

- You need a contract across unrelated classes
- You want loose coupling and easy substitution/mocking
- A class may need to implement multiple behaviors

### 2.3 Practical Selection Rule

Choose interface first for service boundaries and dependencies.
Use abstract class when you need shared base logic plus extension points.

## 3. Interface-Based Architecture and Loose Coupling

Tight coupling:

```java
class OrderService {
    private final StripeGateway gateway = new StripeGateway();
}
```

Loose coupling:

```java
interface PaymentGateway {
    boolean charge(double amount);
}

class OrderService {
    private final PaymentGateway gateway;

    OrderService(PaymentGateway gateway) {
        this.gateway = gateway;
    }
}
```

Benefits:

- Replace implementation without changing `OrderService`
- Easier unit testing with fake/stub gateway
- Cleaner dependency boundaries

## 4. Composition Over Inheritance

Inheritance creates an "is-a" relationship.
Composition creates a "has-a" relationship.

Inheritance may become rigid when subclasses grow with unrelated behavior.

Composition example:

```java
interface NotificationSender {
    void send(String message);
}

class EmailSender implements NotificationSender {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class AlertService {
    private final NotificationSender sender;

    AlertService(NotificationSender sender) {
        this.sender = sender;
    }
}
```

`AlertService` can work with email, SMS, or mock sender without class hierarchy changes.

## 5. Design for Testability

Testable code has clear boundaries and replaceable dependencies.

### 5.1 Core Practices

- Depend on interfaces, not concrete classes
- Inject dependencies through constructors
- Keep business logic separate from I/O (`Scanner`, files, HTTP, DB)
- Avoid hidden global state and static mutable fields

### 5.2 Example Test-Friendly Pattern

```java
interface Clock {
    long nowMillis();
}

class SystemClock implements Clock {
    public long nowMillis() {
        return System.currentTimeMillis();
    }
}
```

A test can pass a fixed clock implementation and assert deterministic behavior.

## 6. Practical Interface-Driven Exercise Blueprint

Mini exercise architecture:

- `DiscountPolicy` interface with `apply(double amount)`
- Implementations:
  - `NoDiscountPolicy`
  - `PercentageDiscountPolicy`
  - `TieredDiscountPolicy`
- `CheckoutService` depends on `DiscountPolicy`
- In tests, pass fake policy to verify checkout logic safely

This structure demonstrates polymorphism, abstraction, composition, and testability in one flow.

## 7. Common Mistakes Checklist

- Using inheritance when composition would be simpler
- Declaring concrete types in service fields instead of interfaces
- Overusing `instanceof` instead of polymorphic method design
- Writing large classes that mix business logic and console/database code
- Skipping `@Override` and accidentally overloading instead of overriding
- Treating interfaces as "extra code" instead of architecture contracts

## 8. Mini Practice Tasks

1. Create one interface and two implementations, then switch them in `main`.
2. Build a base abstract class with shared logic and two concrete subclasses.
3. Demonstrate overloading and overriding in the same mini project.
4. Refactor a concrete service dependency into constructor-injected interface dependency.
5. Replace inheritance in one example with composition and compare readability.
6. Create a fake implementation for a dependency and run a simple test scenario.
7. Build a strategy-style pricing/discount module using interface polymorphism.
8. Build a report generator that accepts different exporters (`Console`, `Csv`, `Json`).

## 9. Summary

Polymorphism and abstraction help you design extensible systems.
Interfaces and composition reduce coupling, while constructor-injected dependencies improve testability.
These practices are essential for building maintainable Java applications beyond beginner-level OOP.
