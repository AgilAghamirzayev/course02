# Lesson 4: Control Flow, Loops and Methods (Java)

This lesson moves from isolated statements to full program logic.  
You will learn how to choose branches, repeat operations safely, and structure logic into reusable methods.

## In-class Coverage

- [ ] `if/else` and `switch` decision-making patterns
- [ ] Looping with `for`, `while`, and `do-while`
- [ ] Method design: parameters, return types, scope
- [ ] Decomposing tasks into reusable methods
- [ ] Practice problems for algorithmic thinking

## Learning Objectives

By the end of this lesson, students will be able to:

- Build decision logic with `if/else if/else` and `switch`
- Choose the right loop type for a task and avoid infinite loops
- Control loops with `break` and `continue`
- Design clear methods with meaningful parameters and return values
- Explain local, block, and method scope
- Split large logic into smaller reusable methods
- Solve beginner algorithmic tasks with a repeatable process

## 1. Decision-Making with `if/else`

### 1.1 Boolean Conditions

Every `if` statement evaluates a boolean expression (`true` or `false`).

```java
int age = 20;
if (age >= 18) {
    System.out.println("Adult");
}
```

### 1.2 `if/else`

Use `if/else` when only two outcomes exist.

```java
double balance = 80;
double withdraw = 100;

if (withdraw <= balance) {
    System.out.println("Withdrawal approved");
} else {
    System.out.println("Insufficient funds");
}
```

### 1.3 `if/else if/else` Chains

Use this when you have multiple ordered conditions.

```java
int score = 76;

if (score >= 90) {
    System.out.println("A");
} else if (score >= 80) {
    System.out.println("B");
} else if (score >= 70) {
    System.out.println("C");
} else {
    System.out.println("Need improvement");
}
```

Order matters. Put more specific/high-priority conditions first.

### 1.4 Guard-Style Checks

For validation, check invalid states early and exit quickly.

```java
if (amount <= 0) {
    System.out.println("Amount must be positive");
    return;
}
```

This keeps business logic cleaner.

## 2. `switch` Decision Patterns

`switch` is often clearer than long `else if` chains when one variable is compared to many exact values.

### 2.1 Classic `switch` Statement

```java
String dayCode = "3";

switch (dayCode) {
    case "1":
        System.out.println("Monday");
        break;
    case "2":
        System.out.println("Tuesday");
        break;
    case "3":
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Invalid input");
}
```

Without `break`, control falls through to the next case.

### 2.2 Modern Arrow `switch`

```java
switch (dayCode) {
    case "1" -> System.out.println("Monday");
    case "2" -> System.out.println("Tuesday");
    case "3" -> System.out.println("Wednesday");
    default -> System.out.println("Invalid input");
}
```

No `break` needed, no accidental fall-through.

### 2.3 `switch` Expression Returning a Value

```java
String day = switch (dayCode) {
    case "1" -> "Monday";
    case "2" -> "Tuesday";
    case "3" -> "Wednesday";
    default -> "Invalid input";
};

System.out.println(day);
```

This is useful when you need to map input to a result.

## 3. Looping in Java

Loops repeat logic until a stop condition is met.

### 3.1 `while` Loop

Use `while` when the number of iterations is unknown in advance.

```java
int step = 1;
while (step <= 5) {
    System.out.println("Step: " + step);
    step++;
}
```

### 3.2 `do-while` Loop

`do-while` runs at least once, then checks the condition.

```java
int step = 1000;
do {
    System.out.println("Step: " + step);
    step++;
} while (step <= 100);
```

The body executes once even though the condition is false initially.

### 3.3 `for` Loop

Use `for` when start, stop, and update are clear.

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("i = " + i);
}
```

### 3.4 Nested Loops

Nested loops are useful for tables, matrix-style tasks, and pattern printing.

```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        System.out.printf("%d x %d = %d%n", i, j, i * j);
    }
    System.out.println();
}
```

### 3.5 `break` and `continue`

- `break` exits the loop immediately
- `continue` skips to the next iteration

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;
    }
    if (i % 2 == 0) {
        continue;
    }
    System.out.println(i);
}
```

### 3.6 Avoiding Infinite Loops

A loop becomes infinite if the condition never becomes false.

Common reasons:

- Missing update (`i++`)
- Wrong condition (`i >= 0` while incrementing)
- Exit condition never reachable

## 4. Method Design Fundamentals

Methods let you package logic into reusable units.

### 4.1 Method Signature

A method signature includes:

- access modifier (`public`, `private`)
- `static` (if called without object in `main` examples)
- return type (`int`, `double`, `void`, ...)
- method name
- parameter list

```java
public static int sum(int a, int b) {
    return a + b;
}
```

### 4.2 Parameters and Return Types

- Parameters are method inputs
- Return type is method output
- Use `void` if no value is returned

```java
public static void printWelcome(String name) {
    System.out.println("Welcome, " + name);
}
```

```java
public static double calculateDiscount(double price, double percent) {
    return price * percent / 100.0;
}
```

### 4.3 Scope in Methods

Variables exist only inside their scope.

```java
public static void demoScope() {
    int x = 10; // visible only in this method
    if (x > 5) {
        int y = 20; // visible only inside this if-block
        System.out.println(x + y);
    }
    // System.out.println(y); // compile error
}
```

### 4.4 Good Method Naming

Use verb-based names that describe behavior:

- `calculateTotal`
- `isValidEmail`
- `printSummary`

Avoid unclear names like `doTask` or `processData1`.

## 5. Decomposing Tasks into Reusable Methods

Large `main` methods become hard to read and debug.  
Break them into small methods with one clear responsibility.

Example calculator structure:

```java
public static int calculate(String operator, int a, int b) {
    return switch (operator) {
        case "+" -> add(a, b);
        case "-" -> subtract(a, b);
        case "*" -> multiply(a, b);
        case "/" -> divide(a, b);
        default -> 0;
    };
}

public static int add(int a, int b) {
    return a + b;
}

public static int subtract(int a, int b) {
    return a - b;
}

public static int multiply(int a, int b) {
    return a * b;
}

public static int divide(int a, int b) {
    return a / b;
}
```

Benefits:

- Easier testing
- Easier bug isolation
- Less duplication
- Better readability for teammates

## 6. Algorithmic Thinking Patterns

Use these patterns repeatedly:

### 6.1 Counting

Count items that match a rule.

```java
int evenCount = 0;
for (int i = 1; i <= 20; i++) {
    if (i % 2 == 0) {
        evenCount++;
    }
}
```

### 6.2 Accumulation (Running Sum)

```java
int sum = 0;
for (int i = 1; i <= 100; i++) {
    sum += i;
}
```

### 6.3 Min/Max Tracking

```java
int[] arr = {7, 3, 11, 2, 9};
int min = arr[0];

for (int i = 1; i < arr.length; i++) {
    if (arr[i] < min) {
        min = arr[i];
    }
}
```

### 6.4 Validation Loops

Repeat input until it is valid.

```java
Scanner sc = new Scanner(System.in);
int age;

do {
    System.out.print("Enter age (1-120): ");
    age = sc.nextInt();
} while (age < 1 || age > 120);
```

## 7. Common Mistakes Checklist

- Missing `break` in classic `switch`
- Writing a condition that never changes inside a loop
- Off-by-one errors (`<= arr.length` instead of `< arr.length`)
- Returning from a method with the wrong type
- Using one method for too many unrelated tasks
- Declaring variables in a narrow scope and trying to use them outside

## 8. Mini Practice Tasks

1. Read a number and print whether it is positive, negative, or zero.
2. Read a day number (`1-7`) and print day name using `switch`.
3. Print numbers from 1 to `N` with `for`, and also print only even numbers.
4. Keep asking for a password until the correct value is entered (`while` loop).
5. Build a multiplication table from 1 to `N` using nested loops.
6. Write methods `add`, `sub`, `mul`, `div` and call them from a `calculate` method.
7. Write a method `isPrime(int n)` and test it for numbers 2 to 100.
8. Refactor one long `main` program into at least 4 reusable methods.

## 9. Summary

Control flow defines program behavior.  
Loops handle repetition, and methods turn repeated logic into clean reusable blocks.  
When combined with clear conditions and good scope management, your code becomes easier to extend, debug, and test.
