# Lesson 4 Practical Tasks - Control Flow, Loops, and Methods

## Objective

The goal of this assignment is to practice program logic in Java using decisions, loops, and reusable methods.

By completing these tasks, students will improve their ability to design predictable control flow, prevent loop bugs, and structure code for readability and reuse.

## Project Structure Requirement

Create one package and 12 task classes:

```text
src/main/java/l4/controlflow/loops/homework/
```

Suggested class naming:

```text
Task01EasyAgeClassifier.java
Task02EasyDayTypeSwitch.java
...
Task12HardQuizEngine.java
```

## Task 1 - Easy Level (Age Category Classifier)

### Instructions

1. Read age from console as an integer.
2. Use `if/else if/else` to classify:
   - `< 0` -> invalid input
   - `0-12` -> child
   - `13-17` -> teen
   - `18-64` -> adult
   - `65+` -> senior
3. Print exactly one category message.

### Expected Result

- Correct ordered condition checks
- No overlapping branches
- Clear single-line output

### Deliverable

A Java class named `Task01EasyAgeClassifier` with runnable `main`.

## Task 2 - Easy Level (Weekday Type with `switch`)

### Instructions

1. Read day number (`1-7`) from console.
2. Use a `switch` expression to map number to day name.
3. Use a second decision block to print `Weekday` or `Weekend`.
4. Handle invalid input with a default message.

### Expected Result

- Correct `switch` usage with default branch
- Accurate day mapping
- Correct weekday/weekend classification

### Deliverable

A Java class named `Task02EasyDayTypeSwitch` with runnable `main`.

## Task 3 - Easy Level (Range Printer and Running Sum)

### Instructions

1. Read `start` and `end` integers.
2. If `start > end`, swap values using an `if` block.
3. Use a `for` loop to print each number in the range.
4. Keep a running sum and print final sum.
5. Inside the same loop, print numbers divisible by 3.

### Expected Result

- Correct loop boundaries
- Running sum logic works
- Correct conditional filtering (`% 3 == 0`)

### Deliverable

A Java class named `Task03EasyRangePrinter` with runnable `main`.

## Task 4 - Easy Level (PIN Validation with Attempts)

### Instructions

1. Set a fixed PIN constant in code (example: `1234`).
2. Ask user for PIN using a `do-while` loop.
3. Allow maximum 3 attempts.
4. If correct, print success and stop.
5. If attempts are exhausted, print account locked message.

### Expected Result

- Proper `do-while` behavior (runs at least once)
- Correct attempt counting
- Correct success/failure branching

### Deliverable

A Java class named `Task04EasyPinValidation` with runnable `main`.

## Task 5 - Medium Level (ATM Withdrawal Decision Flow)

### Instructions

1. Read `accountBalance` and `withdrawalAmount`.
2. Implement ordered validation rules with `if/else if/else`:
   - balance `<= 0` -> no funds
   - amount `<= 0` -> invalid amount
   - amount `> balance` -> insufficient balance
   - amount `> 500` -> OTP required
   - otherwise -> approved
3. When approved, subtract amount and print updated balance.

### Expected Result

- Decision flow matches business rules
- Only one branch executes
- Balance updates only in approved case

### Deliverable

A Java class named `Task05MediumATMDecision` with runnable `main`.

## Task 6 - Medium Level (Interactive Weekday Console)

### Instructions

1. Build a loop that repeatedly asks for day number (`1-7`) or `exit`.
2. Use `switch` to print day name.
3. Use `continue` for invalid input so loop keeps running.
4. Use `break` when input is `exit`.
5. Track and print count of valid day lookups before exiting.

### Expected Result

- Correct sentinel-controlled loop
- Practical use of `continue` and `break`
- Accurate valid-input counter

### Deliverable

A Java class named `Task06MediumWeekdayConsole` with runnable `main`.

## Task 7 - Medium Level (Multiplication Grid with Nested Loops)

### Instructions

1. Read `N` from console.
2. Print an `N x N` multiplication table using nested `for` loops.
3. Format columns with `printf` for alignment.
4. At the end of each row, print the row sum.
5. After table ends, print total sum of all cells.

### Expected Result

- Correct nested-loop structure
- Clean aligned output
- Correct row and total accumulations

### Deliverable

A Java class named `Task07MediumMultiplicationGrid` with runnable `main`.

## Task 8 - Medium Level (Method-Based Calculator)

### Instructions

1. Create methods: `add`, `sub`, `mul`, `div`, `calculate`, `printResult`.
2. In `main`, repeatedly read two integers and an operator (`+`, `-`, `*`, `/`).
3. Route operations via `switch` inside `calculate`.
4. Handle division by zero with a safe message.
5. Ask user whether to continue after each calculation.

### Expected Result

- Logic decomposed into reusable methods
- Correct parameter/return type usage
- Safe handling of invalid operator and division by zero

### Deliverable

A Java class named `Task08MediumMethodCalculator` with runnable `main`.

## Task 9 - Hard Level (Number Analytics Report)

### Instructions

1. Read `N`, then read `N` integers using a loop.
2. Compute:
   - sum
   - average
   - min
   - max
   - count of positive/negative/zero numbers
3. Decompose logic into methods (for example: `updateMin`, `updateMax`, `printSummary`).
4. Print a structured analytics report.

### Expected Result

- Correct accumulator and comparison logic
- Off-by-one-safe loop boundaries
- Method decomposition improves readability

### Deliverable

A Java class named `Task09HardNumberAnalytics` with runnable `main`.

## Task 10 - Hard Level (Prime Range Checker)

### Instructions

1. Read `start` and `end` integers.
2. Normalize range if `start > end`.
3. Implement `isPrime(int n)` method.
4. Use a loop to print all primes in range.
5. Print total prime count at the end.

### Expected Result

- Correct prime-checking logic
- Reusable helper method for primality
- Accurate range traversal and counting

### Deliverable

A Java class named `Task10HardPrimeRangeChecker` with runnable `main`.

## Task 11 - Hard Level (Menu-Driven Converter)

### Instructions

1. Build a looped menu:
   - `1` Celsius -> Fahrenheit
   - `2` Kilometer -> Mile
   - `3` Manat -> USD (use a constant exchange rate)
   - `0` Exit
2. Use `switch` for command routing.
3. Put each conversion in its own method.
4. Handle unsupported menu options without terminating the app.
5. Keep running until user chooses `0`.

### Expected Result

- Combined use of loops + switch + methods
- Clear separation of conversion responsibilities
- Stable interactive behavior

### Deliverable

A Java class named `Task11HardMenuDrivenConverter` with runnable `main`.

## Task 12 - Hard Level (Quiz Engine and Refactor)

### Instructions

1. Build a 5-question console quiz.
2. Store questions and correct answers in arrays.
3. Loop through all questions, read answer, and update score.
4. Use methods such as:
   - `askQuestion(...)`
   - `isCorrectAnswer(...)`
   - `printFinalReport(...)`
5. After final score, assign grade using `if/else` (example: `A/B/C/F`).
6. Ask user if they want to restart; if yes, run quiz again.

### Expected Result

- End-to-end control flow with reusable methods
- Correct scoring and grading logic
- Practical algorithmic problem-solving in one program

### Deliverable

A Java class named `Task12HardQuizEngine` with runnable `main`.

## Final Submission

Submit the 12 Java classes and confirm each class runs from `main`.
