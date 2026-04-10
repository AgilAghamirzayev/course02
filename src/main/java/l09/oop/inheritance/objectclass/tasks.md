# Lesson 9 Practical Tasks - Inheritance and Object Class

## Objective

The goal of this assignment is to build strong inheritance design skills in Java and correctly apply core `Object` methods in real scenarios.

By completing these tasks, students will practice `extends`, `super`, method overriding, dynamic dispatch, and value-based object comparison with `equals`/`hashCode`.

## Project Structure Requirement

Create one package and 12 task classes:

```text
src/main/java/l9/oop/inheritance/objectclass/homework/
```

Suggested class naming:

```text
Task01EasyInheritanceIntro.java
Task02EasySuperConstructor.java
...
Task12HardMiniEmployeeRegistry.java
```

## Task 1 - Easy Level (Inheritance Intro)

### Instructions

1. Create class `Person` with fields `name` and `age`.
2. Create class `Student` that `extends Person` and adds `group`.
3. Add method `printInfo()` in both classes.
4. In `main`, create one `Person` and one `Student` and print info.

### Expected Result

- Correct `extends` usage
- Parent and child object creation works
- Basic inheritance structure is clear

### Deliverable

A Java class named `Task01EasyInheritanceIntro` with runnable `main`.

## Task 2 - Easy Level (`super` Constructor Chaining)

### Instructions

1. Create class `Vehicle` with fields `brand` and `year`.
2. Create class `Car` that extends `Vehicle` and adds `model`.
3. Use `super(brand, year)` inside `Car` constructor.
4. Print all fields in `main`.

### Expected Result

- Constructor chaining via `super(...)`
- No duplicated parent initialization logic
- Clean parent-child constructor design

### Deliverable

A Java class named `Task02EasySuperConstructor` with runnable `main`.

## Task 3 - Easy Level (Method Overriding Basics)

### Instructions

1. Create class `Animal` with method `sound()`.
2. Create `Dog` and `Cat` classes extending `Animal`.
3. Override `sound()` in both child classes.
4. Call `sound()` using parent reference variables.

### Expected Result

- Correct `@Override` usage
- Runtime behavior changes by actual object type
- Clear overriding example

### Deliverable

A Java class named `Task03EasyOverridingBasics` with runnable `main`.

## Task 4 - Easy Level (Dynamic Dispatch with Arrays)

### Instructions

1. Reuse class hierarchy from Task 3 (or create similar).
2. Store mixed child objects in `Animal[]`.
3. Loop through array and call overridden method.
4. Print class name and output for each element.

### Expected Result

- Practical dynamic dispatch demo
- Polymorphic behavior in loops
- Correct base-type collection usage

### Deliverable

A Java class named `Task04EasyDynamicDispatchArray` with runnable `main`.

## Task 5 - Medium Level (`super` Method Call)

### Instructions

1. Create class `Employee` with method `calculatePay()`.
2. Create class `SalariedEmployee` extending `Employee`.
3. Override `calculatePay()` but call `super.calculatePay()` as part of logic.
4. Print both base and final pay breakdown.

### Expected Result

- Correct overridden method extension
- Proper `super.method()` usage
- Transparent salary calculation flow

### Deliverable

A Java class named `Task05MediumSuperMethod` with runnable `main`.

## Task 6 - Medium Level (`toString` for Readable Output)

### Instructions

1. Create class `Book` with fields `isbn`, `title`, `author`.
2. Override `toString()` with clean readable format.
3. Print object directly with `System.out.println(book)`.
4. Compare output before and after custom `toString()` (short comment).

### Expected Result

- Understand default `Object.toString()` behavior
- Useful human-readable object output
- Better debugging experience

### Deliverable

A Java class named `Task06MediumToStringPractice` with runnable `main`.

## Task 7 - Medium Level (`equals` and `hashCode` Contract)

### Instructions

1. Create class `Product` with fields `id`, `name`, `price`.
2. Override `equals()` and `hashCode()` based only on `id`.
3. Create two objects with same `id` but different other fields.
4. Show comparison results in `main`.

### Expected Result

- Value-based equality implemented correctly
- Consistent `equals`/`hashCode` contract
- Clear distinction between identity and value equality

### Deliverable

A Java class named `Task07MediumEqualsHashCode` with runnable `main`.

## Task 8 - Medium Level (HashSet Uniqueness Test)

### Instructions

1. Reuse (or recreate) `Product` from Task 7.
2. Add multiple products into `HashSet<Product>`, including duplicates by `id`.
3. Print set size and all elements.
4. Explain with one code comment why duplicates were removed.

### Expected Result

- Practical `hashCode` impact demonstration
- Correct uniqueness behavior in hash-based collections
- Stronger understanding of object equality in Java collections

### Deliverable

A Java class named `Task08MediumHashSetUniqueness` with runnable `main`.

## Task 9 - Hard Level (Inheritance Tree for Staff)

### Instructions

1. Create hierarchy:
   - `Person` -> `Worker` -> `Employee`
2. Add two concrete subclasses:
   - `HourlyEmployee`
   - `SalariedEmployee`
3. Override `collectPay()` in each child class.
4. Print payroll report using `Employee[]`.

### Expected Result

- Multi-level inheritance design works correctly
- Different pay logic via overriding
- Reusable base contracts and clean extension

### Deliverable

A Java class named `Task09HardStaffInheritanceTree` with runnable `main`.

## Task 10 - Hard Level (Refactor Procedural Payroll to OOP)

### Instructions

1. Start from one procedural style class with many `if/else` branches for employee type.
2. Refactor into inheritance-based classes with overridden methods.
3. Remove large conditional blocks from `main`.
4. Print before/after outputs to validate same business result.

### Expected Result

- Procedural-to-OOP refactor completed
- Cleaner, extensible architecture
- Behavior preserved after refactor

### Deliverable

A Java class named `Task10HardPayrollRefactor` with runnable `main`.

## Task 11 - Hard Level (Object Comparison Pitfalls Lab)

### Instructions

1. Create class `User` with fields `username` and `email`.
2. Implement:
   - `toString()`
   - `equals()`
   - `hashCode()`
3. In `main`, compare:
   - `==` result
   - `.equals()` result
4. Add objects into `HashSet<User>` and show final size.

### Expected Result

- Clear understanding of `==` vs `.equals()`
- Correct object comparison semantics
- Proper integration with hash collections

### Deliverable

A Java class named `Task11HardObjectComparisonLab` with runnable `main`.

## Task 12 - Hard Level (Mini Employee Registry System)

### Instructions

1. Build small console app using inheritance:
   - `Person`
   - `Employee`
   - `HourlyEmployee`
   - `SalariedEmployee`
2. Required features:
   - add employee
   - list all employees (readable `toString`)
   - calculate and print monthly pay
3. Use array or array + count pattern for storage.
4. Ensure each employee has unique `employeeId` using `equals`/`hashCode`.
5. Keep app loop running until user selects exit.

### Expected Result

- End-to-end inheritance + object method practice
- Proper class responsibilities
- Stable and understandable console flow

### Deliverable

A Java class named `Task12HardMiniEmployeeRegistry` with runnable `main`.

## Final Submission

Submit all 12 Java task classes and confirm each class runs from `main`.
