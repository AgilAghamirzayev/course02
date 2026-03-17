# Variables, Data Types, and Operators Interview Questions and Answers

This document provides common Lesson 3 interview questions with short, clear, and practical answers.

## 1. What is a variable in Java?
A variable is a named memory location that stores a value of a specific data type.

## 2. What is the difference between declaration and initialization?
Declaration defines type and name (for example, `int score;`).  
Initialization assigns the first value (for example, `score = 95;`).

## 3. Why must local variables be initialized before use?
Java does not give default values to local variables, so using them before initialization causes a compile-time error.

## 4. What does `final` mean for a variable?
`final` means the variable can be assigned only once. It is used for constants.

## 5. What naming conventions are standard in Java?
Variables and methods use `camelCase`, classes use `PascalCase`, and constants use `UPPER_SNAKE_CASE`.

## 6. What are Java primitive data types?
`byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`.

## 7. Which type is the default choice for whole numbers?
`int` is the default and most common integer type.

## 8. When should we use `long` instead of `int`?
Use `long` when integer values can exceed the `int` range, such as large counters, IDs, or timestamps.

## 9. What is integer overflow?
Overflow happens when a value goes beyond the maximum range of its type and wraps around silently.

## 10. How can we detect arithmetic overflow safely?
Use methods like `Math.addExact`, `Math.subtractExact`, and `Math.multiplyExact`, which throw an exception on overflow.

## 11. Why can `0.1 + 0.2` produce an unexpected result with `double`?
Because many decimal fractions cannot be represented exactly in binary floating-point format.

## 12. When should `BigDecimal` be preferred?
Use `BigDecimal` for money and other exact decimal calculations.

## 13. Why should `BigDecimal` usually be created from a string?
String constructors preserve the exact decimal value, while binary floating literals may already include precision error.

## 14. What is widening conversion?
Widening is automatic conversion from a smaller type to a larger compatible type, such as `int` to `double`.

## 15. What is narrowing conversion?
Narrowing is explicit conversion from a larger type to a smaller one, such as `double` to `int`, and it may lose data.

## 16. What happens in `byte + byte` arithmetic?
Both operands are promoted to `int`, so the result type is `int`.

## 17. What is the difference between `7 / 2` and `7 / 2.0`?
`7 / 2` uses integer division and returns `3`, while `7 / 2.0` uses floating-point division and returns `3.5`.

## 18. What is the `%` operator used for?
It returns the remainder after division.

## 19. What is the difference between `x++` and `++x`?
`x++` returns the old value first, then increments.  
`++x` increments first, then returns the new value.

## 20. What are compound assignment operators?
They combine operation and assignment, for example: `+=`, `-=`, `*=`, `/=`, `%=` and bitwise forms like `&=` and `|=`.

## 21. What do comparison operators return?
Comparison operators (`==`, `!=`, `>`, `<`, `>=`, `<=`) return a `boolean` value.

## 22. How should we compare strings in Java?
Use `.equals()` for content comparison. `==` compares object references.

## 23. What is short-circuit behavior in logical operators?
With `&&` and `||`, Java may skip evaluating the second operand when the result is already known.

## 24. What are bitwise operators used for?
Bitwise operators (`&`, `|`, `^`, `~`) are used for low-level operations like flags, masks, and packed data.

## 25. What is the difference between `>>` and `>>>`?
`>>` is arithmetic right shift (keeps sign bit).  
`>>>` is logical right shift (fills left bits with zeros).
