# Lesson 5 Practical Tasks - Arrays and Strings

## Objective

The goal of this assignment is to practice Java array and string fundamentals through structured tasks.

By completing these tasks, students will improve their ability to model data, traverse collections safely, and build text-processing logic with correct String operations.

## Project Structure Requirement

Create one package and 12 task classes:

```text
src/main/java/l05/arrays/strings/homework/
```

Suggested class naming:

```text
Task01EasyArrayWarmup.java
Task02EasyOddArrayBuilder.java
...
Task12HardStudentAnalyticsConsole.java
```

## Task 1 - Easy Level (Array Warmup)

### Instructions

1. Create an `int[]` of size `10`.
2. Set index `0` to `5` and index `9` to `99`.
3. Print full array with `Arrays.toString`.
4. Print each index-value pair using a loop.

### Expected Result

- Correct index assignment
- Proper loop boundaries
- Clean array output

### Deliverable

A Java class named `Task01EasyArrayWarmup` with runnable `main`.

## Task 2 - Easy Level (Odd Array Builder)

### Instructions

1. Create an `int[]` of size `50`.
2. Fill it with odd numbers in ascending order (`1, 3, 5, ...`).
3. Print full array.
4. Print first and last values.

### Expected Result

- Correct odd-number logic
- No out-of-bounds errors
- Correct start/end values

### Deliverable

A Java class named `Task02EasyOddArrayBuilder` with runnable `main`.

## Task 3 - Easy Level (Age Stats)

### Instructions

1. Create an `int[]` with at least 8 ages.
2. Calculate and print:
   - total sum
   - integer average
   - minimum age
   - maximum age
3. Keep each calculation in a separate method.

### Expected Result

- Correct accumulators and comparisons
- Method decomposition
- Accurate stats output

### Deliverable

A Java class named `Task03EasyAgeStats` with runnable `main`.

## Task 4 - Easy Level (Manual Sort with Clone)

### Instructions

1. Create an unsorted `int[]`.
2. Clone the array into `copy`.
3. Sort only `copy` using bubble sort (no `Arrays.sort`).
4. Print original and sorted arrays to prove original was unchanged.

### Expected Result

- Correct clone usage
- Working ascending sort
- Original array preserved

### Deliverable

A Java class named `Task04EasyManualSort` with runnable `main`.

## Task 5 - Medium Level (2D Matrix Report)

### Instructions

1. Create a `3 x 4` integer matrix (hardcoded values).
2. Print matrix in grid format.
3. Compute and print each row sum.
4. Compute and print each column sum.
5. Print total matrix sum.

### Expected Result

- Correct nested-loop traversal
- Correct row/column accumulations
- Readable tabular output

### Deliverable

A Java class named `Task05MediumMatrixReport` with runnable `main`.

## Task 6 - Medium Level (Seat Finder in 2D Array)

### Instructions

1. Build a 2D `String` array for theater seats (`"A1"`, `"A2"`, ...).
2. Ask user for a seat code.
3. Search matrix and print row/column if found.
4. Print `Seat not found` if missing.
5. Add a boolean flag to avoid duplicate result prints.

### Expected Result

- Correct 2D search logic
- Proper found/not-found handling
- Clear user output

### Deliverable

A Java class named `Task06MediumSeatFinder` with runnable `main`.

## Task 7 - Medium Level (3D Student Average Analyzer)

### Instructions

1. Model marks in a `int[][][]` array (`students x subjects x semesters`).
2. Print all data in readable format.
3. Compute average per student.
4. Compute best subject per student (highest average).
5. Keep logic in separate methods.

### Expected Result

- Correct 3D traversal
- Accurate averages
- Reusable method design

### Deliverable

A Java class named `Task07MediumStudent3DAnalyzer` with runnable `main`.

## Task 8 - Medium Level (String Equality Lab)

### Instructions

1. Create strings using both literals and `new String(...)`.
2. Print results of `==` and `.equals(...)` comparisons.
3. Apply `intern()` to one heap string and compare again.
4. Add short comments that explain each result.

### Expected Result

- Clear distinction between reference and content comparison
- Correct `intern()` demonstration
- Correct use of comments for reasoning

### Deliverable

A Java class named `Task08MediumStringEqualityLab` with runnable `main`.

## Task 9 - Hard Level (String Methods Playground)

### Instructions

1. Start with one sample text (for example: `"  Java,Arrays,Strings  "`).
2. Demonstrate and print results for:
   - `length`, `charAt`, `indexOf`
   - `substring`, `toUpperCase`, `toLowerCase`
   - `startsWith`, `endsWith`, `contains`
   - `replace`, `isEmpty`, `isBlank`
   - `trim` and `strip`
3. Handle at least one invalid index case using guard `if`.

### Expected Result

- Wide String API coverage
- Safe index handling
- Clear labeled outputs

### Deliverable

A Java class named `Task09HardStringMethodsPlayground` with runnable `main`.

## Task 10 - Hard Level (CSV Order Parser)

### Instructions

1. Use input string like: `"apple:2,banana:5,orange:3"`.
2. Split by comma, then split each entry by colon.
3. Store item names into `String[]` and quantities into `int[]`.
4. Calculate total quantity.
5. Print summary line using `String.format` or `.formatted`.

### Expected Result

- Correct `split` chaining
- Proper numeric parsing
- Structured summary output

### Deliverable

A Java class named `Task10HardCsvOrderParser` with runnable `main`.

## Task 11 - Hard Level (Username Validator)

### Instructions

1. Read username from console.
2. Validate with rules:
   - length between 6 and 20
   - starts with letter
   - contains only letters, digits, `_`
   - cannot contain spaces
3. Use String methods (`length`, `charAt`, `contains`) and loop checks.
4. Print full validation report and final result (`VALID` or `INVALID`).

### Expected Result

- Correct multi-rule validation flow
- Good use of String and char logic
- Clear diagnostics for failed rules

### Deliverable

A Java class named `Task11HardUsernameValidator` with runnable `main`.

## Task 12 - Hard Level (Student Analytics Console)

### Instructions

1. Build a small console app using:
   - `String[] studentNames`
   - `int[][] grades` (student x subject)
2. Print menu:
   - `1` Show all students and averages
   - `2` Show top student
   - `3` Search student by name
   - `0` Exit
3. Use loops + methods + String comparisons (`equalsIgnoreCase`).
4. Keep menu running until user exits.

### Expected Result

- Combined usage of arrays + strings + methods
- Accurate averages and top-student logic
- Stable looped menu behavior

### Deliverable

A Java class named `Task12HardStudentAnalyticsConsole` with runnable `main`.

## Final Submission

Submit the 12 Java classes and confirm each class runs from `main`.
