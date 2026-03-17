# Lesson 3: Variables, Data Types, Operators, and Console I/O (Java)

This lesson builds the technical foundation for writing correct Java programs.  
The focus is not only syntax, but also choosing the right types, preventing hidden bugs (overflow/precision), and writing debuggable console applications.

## Learning Objectives

By the end of this lesson, students will be able to:

- Declare, initialize, and update variables correctly
- Apply Java naming conventions for readable code
- Choose primitive types based on range, precision, and memory needs
- Detect and prevent overflow, underflow, and floating-point precision issues
- Explain Unicode, ASCII, and ISO-8859-1 in Java text handling
- Use automatic conversion and explicit casting safely
- Use arithmetic, assignment, comparison, logical, and bitwise operators correctly
- Read input with `Scanner` and format output professionally
- Debug small logic programs with a repeatable process

## 1. Variables: Declaration, Initialization, Naming

### 1.1 What Is a Variable?

A variable is a named memory location that stores a value of a specific type.

```java
int age = 20;
```

- `int` is the type
- `age` is the variable name
- `20` is the value

### 1.2 Declaration vs Initialization

Declaration creates the variable name and type:

```java
int score;
```

Initialization gives it a value:

```java
score = 95;
```

You can do both together:

```java
int score = 95;
```

Important:

- Local variables must be initialized before use
- Instance/static fields get default values automatically (`0`, `false`, `null`, etc.)

```java
public class Demo {
    int fieldScore; // default 0

    public void test() {
        int localScore;
        // System.out.println(localScore); // compile error: not initialized
    }
}
```

### 1.3 Reassignment and Constants

Variables can change:

```java
int x = 10;
x = 15;
```

Use `final` for constants (cannot be reassigned):

```java
final double PI = 3.141592653589793;
```

Naming style for constants: `UPPER_SNAKE_CASE`.

### 1.4 Naming Conventions (Java Standard)

Good naming improves maintainability.

- Variables and methods: `camelCase` (`studentCount`, `calculateTotal`)
- Classes: `PascalCase` (`StudentService`)
- Constants (`final`): `UPPER_SNAKE_CASE` (`MAX_RETRY_COUNT`)

Rules:

- Must start with letter, `_`, or `$` (practically, start with a letter)
- Cannot use Java keywords (`class`, `int`, `if`, ...)
- Case-sensitive (`userName` and `username` are different)

Examples:

```java
int n;              // legal but unclear
int numberOfUsers;  // better
double temp;        // unclear
double averageTemperatureCelsius; // better
```

## 2. Primitive Types and Type Selection Strategy

Java has 8 primitive types:

| Type | Size | Range / Precision | Typical Usage |
|---|---:|---|---|
| `byte` | 8-bit | -128 to 127 | Raw bytes, compact arrays |
| `short` | 16-bit | -32,768 to 32,767 | Rarely used; constrained data |
| `int` | 32-bit | -2^31 to 2^31-1 | Default integer choice |
| `long` | 64-bit | -2^63 to 2^63-1 | Large counts, IDs, timestamps |
| `float` | 32-bit IEEE 754 | ~6-7 decimal digits | Rare; memory-sensitive calculations |
| `double` | 64-bit IEEE 754 | ~15-16 decimal digits | Default floating-point choice |
| `char` | 16-bit unsigned | 0 to 65,535 (UTF-16 code unit) | Single UTF-16 code unit |
| `boolean` | JVM-dependent | `true` / `false` | Logical state |

### 2.1 Type Selection Strategy

Use this decision logic:

1. Is it whole-number data?
   - Yes: prefer `int`
   - Need very large range: use `long`
2. Is it decimal data?
   - Scientific/general numeric: `double`
   - Money/financial exactness: avoid `double`; use `BigDecimal`
3. Is it true/false? use `boolean`
4. Is it textual?
   - Use `String` for text
   - Use `char` only when you need a single UTF-16 code unit

Practical guideline: start with `int`, `double`, `boolean`, `String`; move to other types only with a clear reason.

## 3. Overflow, Underflow, and Precision Problems

### 3.1 Integer Overflow and Underflow

Overflow means going above max value; underflow means below min value.

```java
int max = Integer.MAX_VALUE; // 2147483647
int overflowed = max + 1;    // wraps to -2147483648
System.out.println(overflowed);
```

This wrap-around is silent for primitive integers.

Safe options:

- Check bounds manually
- Use `Math.addExact`, `Math.subtractExact`, `Math.multiplyExact` (throws `ArithmeticException` on overflow)

```java
int safe = Math.addExact(Integer.MAX_VALUE, 1); // throws exception
```

### 3.2 Floating-Point Precision Issues

`float` and `double` cannot represent most decimal fractions exactly.

```java
double value = 0.1 + 0.2;
System.out.println(value); // 0.30000000000000004
```

Best practices:

- For money: use `BigDecimal`
- For comparisons: use epsilon tolerance

```java
double a = 0.3;
double b = 0.1 + 0.2;
boolean equal = Math.abs(a - b) < 1e-9;
```

### 3.3 `BigDecimal` for Exact Decimal Math

```java
import java.math.BigDecimal;

BigDecimal price = new BigDecimal("19.99");
BigDecimal tax = new BigDecimal("1.50");
BigDecimal total = price.add(tax); // exact decimal result
```

Use string constructors (`new BigDecimal("19.99")`), not binary floating literals.

## 4. Java Text Model: Unicode, ASCII, ISO-8859-1

### 4.1 Unicode in Java

Java uses Unicode for text.  
`String` stores text as UTF-16 code units internally.

Key distinction:

- Unicode code point: abstract character (`U+0041`, `U+1F600`, etc.)
- UTF-16 code unit: storage unit; `char` holds one code unit, not always one full character

Emoji and many symbols outside the Basic Multilingual Plane use surrogate pairs (two `char` values).

```java
String s = "A😀";
System.out.println(s.length()); // 3 (A = 1 code unit, 😀 = 2 code units)
System.out.println(s.codePointCount(0, s.length())); // 2 code points
```

### 4.2 ASCII

ASCII is a 7-bit subset (0-127), includes English letters, digits, punctuation, control chars.

- `'A'` is 65
- `'0'` is 48

```java
char c = 'A';
int code = c; // 65
```

### 4.3 ISO-8859-1 (Latin-1)

ISO-8859-1 is an 8-bit legacy encoding (0-255) for many Western European characters.  
It is not enough for global multilingual text.

When encoding/decoding bytes, always specify charset explicitly:

```java
import java.nio.charset.StandardCharsets;

byte[] utf8 = "Café".getBytes(StandardCharsets.UTF_8);
byte[] latin1 = "Café".getBytes(StandardCharsets.ISO_8859_1);
```

Best practice:

- Prefer UTF-8 for files, APIs, and inter-system communication
- Avoid relying on platform default charset

## 5. Type Casting and Automatic Type Conversion

### 5.1 Widening Conversion (Automatic, Safe)

Smaller range to larger range:

```java
int i = 42;
double d = i; // automatic
```

Common widening path:

- `byte -> short -> int -> long -> float -> double`
- `char -> int -> long -> float -> double`

### 5.2 Narrowing Conversion (Explicit, Potential Data Loss)

```java
double d = 9.8;
int i = (int) d; // 9, fractional part lost
```

```java
int large = 130;
byte small = (byte) large; // -126 (overflow wrap)
```

### 5.3 Numeric Promotion in Expressions

In arithmetic expressions:

- `byte`, `short`, `char` are promoted to `int`
- Then Java promotes to the widest operand type

```java
byte a = 10;
byte b = 20;
// byte c = a + b; // compile error: result is int
byte c = (byte) (a + b);
```

### 5.4 Type Conversion Errors

Compile-time conversion errors:

```java
// int x = "123"; // incompatible types
// boolean ok = 1; // incompatible types
```

Runtime conversion/parsing errors:

```java
int n = Integer.parseInt("12A"); // NumberFormatException
```

When reading user input, validate before converting.

## 6. Operators in Java

### 6.1 Arithmetic Operators

- `+`, `-`, `*`, `/`, `%`

```java
int a = 7 / 2;      // 3 (integer division)
double b = 7 / 2.0; // 3.5
int r = 7 % 2;      // 1
```

Increment/decrement:

```java
int x = 5;
int y = x++; // y=5, x=6
int z = ++x; // x=7, z=7
```

### 6.2 Assignment Operators

- Basic: `=`
- Compound: `+=`, `-=`, `*=`, `/=`, `%=`, `&=`, `|=`, `^=`, `<<=`, `>>=`, `>>>=`

```java
int n = 10;
n += 5; // n = 15
```

### 6.3 Comparison Operators

- `==`, `!=`, `>`, `<`, `>=`, `<=`
- Result type is `boolean`

```java
int age = 20;
boolean adult = age >= 18;
```

For strings, use `.equals`, not `==`:

```java
String a = "java";
String b = new String("java");
System.out.println(a == b);      // false (reference comparison)
System.out.println(a.equals(b)); // true  (content comparison)
```

### 6.4 Logical Operators

- Short-circuit: `&&`, `||`
- Logical NOT: `!`

```java
int x = 0;
if (x != 0 && 10 / x > 1) { // safe due to short-circuit
    System.out.println("ok");
}
```

Non-short-circuit boolean operators:

- `&`, `|`, `^` can also operate on booleans (both sides evaluated)

### 6.5 Bitwise and Shift Operators

Bitwise:

- `&` AND
- `|` OR
- `^` XOR
- `~` NOT

Shift:

- `<<` left shift
- `>>` arithmetic right shift (keeps sign)
- `>>>` logical right shift (fills with zeros)

```java
int p = 5;   // 0101
int q = 3;   // 0011
int and = p & q; // 0001 = 1
int or  = p | q; // 0111 = 7
int xor = p ^ q; // 0110 = 6
```

Use cases: flags, low-level protocols, performance-sensitive utilities.

## 7. Console Input with `Scanner` and Output Formatting

### 7.1 Basic Input with `Scanner`

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
System.out.print("Enter age: ");
int age = sc.nextInt();
System.out.println("Age = " + age);
```

Common methods:

- `nextInt()`, `nextLong()`, `nextDouble()`, `nextBoolean()`
- `next()` reads one token
- `nextLine()` reads the full line

### 7.2 `nextLine()` Trap After Numeric Input

`nextInt()` leaves newline in buffer.

```java
int age = sc.nextInt();
sc.nextLine(); // consume leftover newline
String name = sc.nextLine();
```

Without the extra `nextLine()`, `name` may be read as empty.

### 7.3 Input Validation Best Practice

```java
System.out.print("Enter integer count: ");
while (!sc.hasNextInt()) {
    System.out.print("Invalid input. Enter an integer: ");
    sc.next(); // discard invalid token
}
int count = sc.nextInt();
```

This avoids `InputMismatchException`.

### 7.4 Output Formatting (`printf`)

Use `printf` for readable, aligned output:

```java
System.out.printf("Name: %-10s | Age: %2d | GPA: %.2f%n", "Aylin", 21, 3.756);
```

Formatting tips:

- Use `%n` (portable newline) instead of `\n`
- Limit decimals for user-facing values (`%.2f`)
- Align columns for tables (`%-10s`, `%8d`)

## 8. Debugging Small Logic Programs

Debugging is a process, not guesswork.

### 8.1 Practical Debugging Workflow

1. Reproduce the bug reliably with a fixed input.
2. Isolate the smallest code section that still fails.
3. Print key variables before/after critical lines.
4. Check type behavior (integer division, casts, overflow, null).
5. Verify branch conditions (`if`, loops, boundaries).
6. Confirm expected vs actual output with test cases.
7. Fix one thing at a time and re-run.

### 8.2 Example: Hidden Integer Division Bug

Buggy code:

```java
int sum = 7;
int count = 2;
double average = sum / count; // result becomes 3.0, not 3.5
System.out.println(average);
```

Why wrong:

- `sum / count` uses integer division first (`3`)
- Then `3` is converted to `3.0`

Correct:

```java
double average = (double) sum / count; // 3.5
```

### 8.3 Example: Off-by-One Loop Error

Buggy code:

```java
for (int i = 0; i <= arr.length; i++) {
    System.out.println(arr[i]); // ArrayIndexOutOfBoundsException at last iteration
}
```

Correct:

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

## 9. Common Mistakes Checklist

- Using `==` for string content comparison instead of `.equals`
- Forgetting that `int / int` truncates decimals
- Assuming `double` is exact for money
- Ignoring overflow risk in counters/accumulators
- Forgetting `nextLine()` after `nextInt()`
- Casting without checking data loss
- Choosing unclear variable names (`x1`, `tmp2`) in business logic

## 10. Mini Practice Tasks

1. Read two integers and print sum, difference, product, quotient, and remainder.
2. Read principal, rate, and years; compute simple interest with formatted output.
3. Demonstrate overflow with `Integer.MAX_VALUE + 1`, then prevent it with `Math.addExact`.
4. Read a full name and age, then print a formatted profile row using `printf`.
5. Write a program that checks if an input number is even and between 10 and 100 (inclusive).

## 11. Summary

Strong Java fundamentals come from correct type choices, safe conversions, and predictable input/output handling.  
When programs fail, most beginner bugs are from type behavior (division/casting/overflow), operator misuse, and input parsing assumptions.  
A systematic debugging method turns these into quick, repeatable fixes.
