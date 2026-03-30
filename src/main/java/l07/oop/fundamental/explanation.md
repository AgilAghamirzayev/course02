# Lesson 7: OOP Fundamentals

This lesson introduces object-oriented programming in Java using practical class design.
You will learn how to model real-world entities with classes, protect object state with encapsulation, and build clean method-based behavior.

## In-class coverage:

- [ ] Classes, objects, fields, methods, constructors
- [ ] Encapsulation and access modifiers
- [ ] `this` keyword and object state management
- [ ] Designing simple domain models
- [ ] OOP coding lab with mini assignment

## Learning Objectives

By the end of this lesson, students will be able to:

- Create classes and instantiate objects
- Define fields and methods with meaningful responsibilities
- Write constructors to initialize object state safely
- Apply encapsulation using `private` fields and controlled methods
- Use access modifiers (`public`, `private`, `protected`, default) correctly
- Use `this` to resolve naming conflicts and refer to current object
- Design small domain models with clear structure and behavior

## 1. Classes and Objects

### 1.1 Class Definition

A class is a blueprint for objects.

```java
public class Student {
    String name;
    int age;
}
```

### 1.2 Object Creation

```java
Student s1 = new Student();
s1.name = "Aylin";
s1.age = 20;
```

Each object has its own state.

## 2. Fields, Methods, and Constructors

### 2.1 Fields

Fields store object data.

```java
private String owner;
private double balance;
```

### 2.2 Methods

Methods define object behavior.

```java
public void deposit(double amount) {
    balance += amount;
}
```

### 2.3 Constructors

Constructors initialize objects at creation time.

```java
public BankAccount(String owner, double balance) {
    this.owner = owner;
    this.balance = balance;
}
```

No return type is used for constructors.

## 3. Encapsulation and Access Modifiers

Encapsulation means protecting internal data and exposing controlled operations.

### 3.1 Why Encapsulation?

- Prevent invalid object states
- Enforce business rules in one place
- Improve maintainability

### 3.2 Access Modifiers Overview

- `public`: accessible from everywhere
- `private`: accessible only inside the same class
- `protected`: accessible in same package and subclasses
- default (no modifier): package-private access

### 3.3 Getter and Setter Pattern

```java
public class Product {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }
}
```

## 4. `this` Keyword and Object State

`this` refers to the current object.

Common use cases:

- resolve parameter-field name conflicts
- pass current instance to another method/object
- chain constructors via `this(...)`

```java
public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }
}
```

Without `this`, assignment may target only the local parameter.

## 5. Designing Simple Domain Models

A domain model represents a real business concept in code.

Examples:

- `Car` with fields: `brand`, `year`, `speed`
- `Book` with fields: `title`, `author`, `available`
- `BankAccount` with fields and methods: `deposit`, `withdraw`, `printSummary`

Design tips:

- keep one clear responsibility per class
- keep fields `private` by default
- expose only necessary methods
- validate data in constructors/setters

## 6. Object Collaboration Basics

Objects can contain or use other objects.

Example:

- `Classroom` has `Student[] students`
- `Order` has `Customer customer` and `Product[] items`

This improves structure and code readability.

## 7. Common Mistakes Checklist

- Making all fields `public`
- Skipping validation in constructors/setters
- Confusing class-level design with one long `main` method
- Repeating the same logic in multiple classes
- Forgetting to initialize required fields
- Using unclear method names (`doTask`, `process`)

## 8. Mini Practice Tasks

1. Create a `Student` class with fields, constructor, and `printInfo` method.
2. Create a `Rectangle` class with methods `area()` and `perimeter()`.
3. Build a `BankAccount` class with `deposit`, `withdraw`, and validation.
4. Build a `Car` class where `accelerate` and `brake` update speed safely.
5. Create a `Book` class with `borrow()` and `returnBook()` behavior.
6. Create a `Product` class and protect price with validation.
7. Build a `Library` class that stores and prints a list of books.
8. Refactor one procedural program into 3 small collaborating classes.

## 9. Summary

OOP helps you organize code around objects with state and behavior.
Classes, constructors, and methods provide structure, while encapsulation keeps data safe.
With good object design, programs become easier to test, reuse, and extend.
