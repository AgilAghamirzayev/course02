# Lesson 3 Practical Tasks - Variables, Data Types, and Operators

## Objective

The goal of this assignment is to practice Java fundamentals through real-world scenarios using variables, primitive types, casting, precision handling, operators, and formatted output.

By completing these tasks, students will build strong habits for writing predictable and debuggable Java code.

## Project Structure Requirement

Create one package and 12 task classes:

```text
src/main/java/l03/variables/homework/
```

Suggested class naming:

```text
Task01EasyEmployeeBadge.java
Task02EasyCartTotals.java
...
Task12HardCheckoutDebug.java
```

## Task 1 - Easy Level (Employee Badge Snapshot)

### Instructions

1. Declare variables for an employee profile: name, age, department, years at company, active status (`boolean`), hourly rate.
2. Add one constant with `final` for company name.
3. Increase hourly rate once using a compound assignment operator (`+=`).
4. Print a one-line badge summary using `printf`.

### Expected Result

- Correct variable declaration and initialization
- Proper use of `final` constant naming (`UPPER_SNAKE_CASE`)
- Formatted output row with readable values

### Deliverable

A Java class named `Task01EasyEmployeeBadge` with runnable `main`.

## Task 2 - Easy Level (Online Grocery Cart Totals)

### Instructions

1. Create variables for 3 products: quantity (`int`) and unit price (`double`) for each.
2. Calculate subtotal using arithmetic operators.
3. Add delivery fee and platform fee.
4. Apply a fixed coupon discount using `-=` operator.
5. Print subtotal, fees, discount, and final total (2 decimal places).

### Expected Result

- Correct arithmetic calculations
- Visible use of assignment and compound assignment operators
- Clean financial output formatting

### Deliverable

A Java class named `Task02EasyCartTotals` with runnable `main`.

## Task 3 - Easy Level (Trip Fuel Consumption)

### Instructions

1. Declare `distanceKm` (`int`) and `fuelLiters` (`double`) for a delivery trip.
2. Calculate `litersPer100Km = (fuelLiters / distanceKm) * 100`.
3. Add `estimatedTripCost` using a `pricePerLiter` variable.
4. Print all metrics with clear labels.

### Expected Result

- Proper use of mixed numeric types (`int` + `double`)
- Practical formula implementation
- Readable numeric output

### Deliverable

A Java class named `Task03EasyFuelUsage` with runnable `main`.

## Task 4 - Easy Level (Character Codes for Product Labels)

### Instructions

1. Declare 4 `char` values used in labels (example: `'A'`, `'7'`, `'-'`, `'#'`).
2. Convert each `char` to its integer code and print the result.
3. Create a `String` containing one emoji (example: `"A😀"`).
4. Print both `length()` and `codePointCount(...)`.

### Expected Result

- Correct `char` and `String` usage
- Demonstration of ASCII/Unicode basics
- Visible difference between UTF-16 length and code point count

### Deliverable

A Java class named `Task04EasyCharCodes` with runnable `main`.

## Task 5 - Medium Level (Invoice Precision: double vs BigDecimal)

### Instructions

1. Build an invoice with decimal values (example: `19.99`, `5.75`, `2.40`) using `double`.
2. Compute invoice total with `double` and print it.
3. Rebuild the same invoice using `BigDecimal` string constructors.
4. Compute exact `BigDecimal` total and print it.
5. Print the numeric difference between both totals.

### Expected Result

- Clear demonstration of floating-point precision behavior
- Correct use of `BigDecimal` for exact decimal math
- Real-world finance-oriented calculation

### Deliverable

A Java class named `Task05MediumInvoicePrecision` with runnable `main`.

## Task 6 - Medium Level (Warehouse Counter Overflow)

### Instructions

1. Start with `int packageCounter = Integer.MAX_VALUE - 2`.
2. Add 1 three times and print each step to show overflow behavior.
3. In a second section, repeat with `Math.addExact(...)` calls.
4. Observe and document (in a short code comment) what happens when overflow is detected.

### Expected Result

- Visible integer overflow wrap-around with normal arithmetic
- Overflow detection with `Math.addExact`
- Better awareness for safe counter logic

### Deliverable

A Java class named `Task06MediumOverflowSafety` with runnable `main`.

## Task 7 - Medium Level (Manufacturing Data Casting)

### Instructions

1. Use a `double` measurement (example: `127.85`) and cast it to `int`.
2. Use an `int` value (example: `130`) and cast it to `byte`.
3. Declare two `byte` sensor values and add them.
4. Store the sum in `int`, then explicitly cast to `byte` in a second variable.
5. Print all results with labels.

### Expected Result

- Correct widening/narrowing conversion examples
- Demonstration of possible data loss
- Numeric promotion behavior (`byte + byte` -> `int`)

### Deliverable

A Java class named `Task07MediumCastingData` with runnable `main`.

## Task 8 - Medium Level (Permission Flags with Bitwise Operators)

### Instructions

1. Define constants for permission flags:
   - `READ = 1`
   - `WRITE = 2`
   - `EXPORT = 4`
   - `AUDIT = 8`
2. Build a user permission mask using `|`.
3. Create booleans using comparisons such as `(mask & READ) != 0`.
4. Update mask with compound operators (`|=`, `&=`, `^=`) and print each state.
5. Print decimal and binary forms of the final mask.

### Expected Result

- Practical usage of bitwise and assignment operators
- Correct boolean comparisons from bit masks
- Strong understanding of flags-based access modeling

### Deliverable

A Java class named `Task08MediumPermissionFlags` with runnable `main`.

## Task 9 - Hard Level (Monthly Salary Slip Generator)

### Instructions

1. Create payroll values with `BigDecimal`: base salary, overtime hours/rate, bonus.
2. Define tax and pension rates as constants.
3. Compute:
   - gross salary
   - tax amount
   - pension amount
   - net salary
4. Format output as an aligned salary slip table using `printf`.
5. Keep all monetary results at 2 decimal places.

### Expected Result

- End-to-end salary math with exact decimals
- Professional formatted console output
- Correct use of constants and reusable expressions

### Deliverable

A Java class named `Task09HardSalarySlip` with runnable `main`.

## Task 10 - Hard Level (Global Text Encoding Check)

### Instructions

1. Create a product title containing multilingual text (example: `"Café Bakı 😀"`).
2. Convert the same title into byte arrays using:
   - `StandardCharsets.UTF_8`
   - `StandardCharsets.ISO_8859_1`
3. Print string `length()`, `codePointCount(...)`, UTF-8 byte count, and ISO-8859-1 byte count.
4. Declare two `char` values from the title and print their integer code values.

### Expected Result

- Practical understanding of Unicode and legacy encodings
- Awareness that encoding choice changes byte representation
- Correct handling of text metrics in Java

### Deliverable

A Java class named `Task10HardEncodingCheck` with runnable `main`.

## Task 11 - Hard Level (IoT Sensor Packet Bit Packing)

### Instructions

1. Use three sensor values:
   - temperature (0-63)
   - humidity (0-127)
   - battery level (0-15)
2. Pack them into one `int` using shifts and bitwise OR.
3. Unpack each value using shifts and masks.
4. Print original values, packed integer, binary representation, and unpacked values.

### Expected Result

- Correct use of `<<`, `>>`, `&`, `|`
- Reliable pack/unpack workflow used in low-level systems
- Matching original and unpacked values

### Deliverable

A Java class named `Task11HardSensorPacket` with runnable `main`.

## Task 12 - Hard Level (Checkout Debug and Fix)

### Instructions

1. Start with intentionally buggy checkout calculations:
   - integer division used in a percentage formula
   - string content comparison written with `==`
   - risky large-number addition with plain `+`
2. Print buggy outputs first.
3. Fix each issue using:
   - explicit casting for decimal division
   - `.equals(...)` for string content comparison
   - `Math.addExact(...)` for safe integer addition
4. Print corrected outputs and add short comments explaining each fix.

### Expected Result

- Hands-on debugging of common beginner mistakes
- Safer numeric and string handling
- Before/after comparison visible in one run

### Deliverable

A Java class named `Task12HardCheckoutDebug` with runnable `main`.

## Final Submission

Submit the 12 Java classes and confirm each class runs from `main` without `Scanner` and without `if / else`.
