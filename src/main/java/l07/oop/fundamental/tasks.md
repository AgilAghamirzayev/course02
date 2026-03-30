# Lesson 7 Practical Tasks - OOP Fundamentals

## Objective

The goal of this assignment is to practice object-oriented design in Java through small domain-driven tasks.

By completing these tasks, students will improve their ability to model entities, manage object state safely, and write reusable class-based code.

## Project Structure Requirement

Create one package and 12 task classes:

```text
src/main/java/l07/oop/fundamental/homework/
```

Suggested class naming:

```text
Task01EasyStudentClass.java
Task02EasyRectangleModel.java
...
Task12HardMiniSchoolSystem.java
```

## Task 1 - Easy Level (Student Class Basics)

### Instructions

1. Create a `Student` class with fields: `name`, `age`, `group`.
2. Add a constructor for all fields.
3. Add method `printInfo()` to print student details.
4. In `main`, create at least 2 `Student` objects and print both.

### Expected Result

- Correct class and object creation
- Constructor-based initialization
- Readable object output

### Deliverable

A Java class named `Task01EasyStudentClass` with runnable `main`.

## Task 2 - Easy Level (Rectangle Domain Model)

### Instructions

1. Create a `Rectangle` class with `width` and `height`.
2. Add constructor and methods:
   - `double area()`
   - `double perimeter()`
3. Create 2 rectangles in `main`.
4. Print area and perimeter for each.

### Expected Result

- Clear method-based behavior
- Correct formula implementation
- Reusable class design

### Deliverable

A Java class named `Task02EasyRectangleModel` with runnable `main`.

## Task 3 - Easy Level (BankAccount with Validation)

### Instructions

1. Create `BankAccount` class with private fields: `owner`, `balance`.
2. Add constructor and methods:
   - `deposit(double amount)`
   - `withdraw(double amount)`
   - `printSummary()`
3. Prevent invalid operations (`amount <= 0`, overdraft).
4. In `main`, run several operations and print final state.

### Expected Result

- Correct encapsulation with private fields
- Safe validation rules
- Proper state updates

### Deliverable

A Java class named `Task03EasyBankAccount` with runnable `main`.

## Task 4 - Easy Level (Car Speed Controller)

### Instructions

1. Create a `Car` class with fields: `brand`, `speed`, `maxSpeed`.
2. Add methods:
   - `accelerate(int delta)`
   - `brake(int delta)`
3. Ensure speed is always between `0` and `maxSpeed`.
4. Print speed after each operation.

### Expected Result

- Controlled state transitions
- Correct boundary protection
- Clear method behavior

### Deliverable

A Java class named `Task04EasyCarController` with runnable `main`.

## Task 5 - Medium Level (Encapsulation Practice with Product)

### Instructions

1. Create `Product` class with private fields: `name`, `price`, `stock`.
2. Add getters and setters with validation:
   - `price >= 0`
   - `stock >= 0`
3. Add method `sell(int quantity)` that reduces stock safely.
4. Print product summary after operations.

### Expected Result

- Proper access control
- Correct setter validation
- Correct stock update logic

### Deliverable

A Java class named `Task05MediumProductEncapsulation` with runnable `main`.

## Task 6 - Medium Level (`this` Keyword Constructor Lab)

### Instructions

1. Create `UserProfile` class with fields: `username`, `email`, `active`.
2. Implement constructor overloading:
   - full constructor
   - constructor with only `username` and `email` (`active = true`)
3. Use `this(...)` constructor chaining.
4. Use `this.field = parameter` in constructors/setters.

### Expected Result

- Correct `this` usage
- Constructor chaining works correctly
- No duplicate initialization logic

### Deliverable

A Java class named `Task06MediumThisKeywordLab` with runnable `main`.

## Task 7 - Medium Level (Book and Library Mini Model)

### Instructions

1. Create `Book` class with private fields: `title`, `author`, `available`.
2. Add methods `borrow()` and `returnBook()`.
3. Create `Library` class with `Book[] books`.
4. Add method to list all books and their availability.
5. In `main`, borrow/return some books and print status.

### Expected Result

- Object collaboration between classes
- Correct state changes for availability
- Readable domain model

### Deliverable

A Java class named `Task07MediumBookLibraryModel` with runnable `main`.

## Task 8 - Medium Level (Employee Payroll Model)

### Instructions

1. Create `Employee` class with fields: `name`, `baseSalary`, `bonus`.
2. Add method `double calculateNetSalary(double taxRate)`.
3. Validate `taxRate` range (`0` to `1`).
4. Create 3 employees and print salary report.

### Expected Result

- Clean business method design
- Correct numeric calculation
- Validation for invalid tax rates

### Deliverable

A Java class named `Task08MediumEmployeePayroll` with runnable `main`.

## Task 9 - Hard Level (Course Enrollment System)

### Instructions

1. Create classes:
   - `Course` (`name`, `capacity`, `Student[] enrolled`)
   - `Student` (`id`, `name`)
2. Add methods:
   - `boolean enroll(Student s)`
   - `void printEnrolledStudents()`
3. Prevent enrollment when capacity is full.
4. Print clear success/failure messages.

### Expected Result

- Multi-class collaboration
- Correct capacity checks
- Consistent enrollment logic

### Deliverable

A Java class named `Task09HardCourseEnrollmentSystem` with runnable `main`.

## Task 10 - Hard Level (Order and Cart Model)

### Instructions

1. Create classes:
   - `CartItem` (`name`, `unitPrice`, `quantity`)
   - `Order` (`CartItem[] items`)
2. Add methods:
   - `double calculateSubtotal()`
   - `double calculateTotal(double taxRate, double shipping)`
   - `void printInvoice()`
3. Validate that quantity is positive.
4. Print formatted invoice output.

### Expected Result

- Strong domain modeling
- Correct aggregation calculations
- Professional invoice output

### Deliverable

A Java class named `Task10HardOrderCartModel` with runnable `main`.

## Task 11 - Hard Level (Classroom Performance Report)

### Instructions

1. Create `Student` class with `name` and `int[] scores`.
2. Add methods:
   - `averageScore()`
   - `maxScore()`
3. Create `Classroom` class with `Student[] students`.
4. Add methods to print:
   - each student average
   - top student in class

### Expected Result

- OOP + array integration
- Correct average and max logic
- Accurate top-student detection

### Deliverable

A Java class named `Task11HardClassroomReport` with runnable `main`.

## Task 12 - Hard Level (Mini School System Lab)

### Instructions

1. Build a small menu-driven console app with classes:
   - `Student`
   - `Teacher`
   - `SchoolService`
2. Menu options:
   - `1` Add student
   - `2` Add teacher
   - `3` List all people
   - `0` Exit
3. Keep data in arrays (or array + count pattern).
4. Use methods and encapsulation (no public mutable fields).
5. Keep loop running until user exits.

### Expected Result

- End-to-end OOP practice in one program
- Proper class responsibilities
- Stable interactive flow

### Deliverable

A Java class named `Task12HardMiniSchoolSystem` with runnable `main`.

## Final Submission

Submit the 12 Java classes and confirm each class runs from `main`.
