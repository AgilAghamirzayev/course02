# Lesson 6 Practical Tasks - Algorithms and Data Structures

## Objective

The goal of this assignment is to practice core algorithm and data-structure thinking in Java.

By completing these tasks, students will improve their ability to choose the right pattern, write efficient solutions, and explain time/space complexity.

## Project Structure Requirement

Create one package and 12 task classes:

```text
src/main/java/l06/algorithims/datastructures/homework/
```

Suggested class naming:

```text
Task01EasyArrayTraversal.java
Task02EasyLinearSearch.java
...
Task12HardPatternInterviewSet.java
```

## Task 1 - Easy Level (Array Traversal and Running Sum)

### Instructions

1. Create an `int[]` with at least 12 values.
2. Print all elements using:
   - classic `for` loop
   - enhanced `for-each` loop
3. Compute running sum and print final sum.
4. Print count of even and odd numbers.

### Expected Result

- Correct array traversal with both loop styles
- Accurate running sum
- Correct even/odd counts

### Deliverable

A Java class named `Task01EasyArrayTraversal` with runnable `main`.

## Task 2 - Easy Level (Linear Search with Index Report)

### Instructions

1. Read target number from console.
2. Search target in a predefined integer array using linear search.
3. If found, print first index and value.
4. If not found, print `Not found`.
5. Add a method `linearSearch(int[] arr, int target)` returning index or `-1`.

### Expected Result

- Correct `-1` fallback behavior
- Clean method decomposition
- Predictable console output

### Deliverable

A Java class named `Task02EasyLinearSearch` with runnable `main`.

## Task 3 - Easy Level (Min, Max, Average Analyzer)

### Instructions

1. Use an integer array of student points.
2. Compute:
   - minimum
   - maximum
   - average
3. Keep each operation in separate methods.
4. Print a one-line summary using `printf`.

### Expected Result

- Correct comparison logic
- Accurate average calculation
- Reusable helper methods

### Deliverable

A Java class named `Task03EasyMinMaxAndAverage` with runnable `main`.

## Task 4 - Easy Level (Duplicate Counter with Frequency Array)

### Instructions

1. Use an integer array where values are between `0` and `20`.
2. Build a frequency array of size `21`.
3. Print each value and its frequency if frequency > 0.
4. Print duplicate count (values appearing more than once).

### Expected Result

- Correct index-based counting
- Correct duplicate detection
- Efficient O(n) counting approach

### Deliverable

A Java class named `Task04EasyDuplicateCounter` with runnable `main`.

## Task 5 - Medium Level (Two Sum in Sorted Array)

### Instructions

1. Use a sorted integer array and a target sum.
2. Implement two-pointers solution (`left`, `right`).
3. Print indices and values if a pair exists.
4. Print `No pair found` otherwise.
5. Add method `findPair(int[] arr, int target)`.

### Expected Result

- Correct pointer movement rules
- O(n) solution for sorted input
- Clear found/not-found output

### Deliverable

A Java class named `Task05MediumTwoSumSorted` with runnable `main`.

## Task 6 - Medium Level (Sliding Window Max Sum of Size K)

### Instructions

1. Read or define `k` and integer array.
2. Compute max sum of every contiguous subarray of size `k`.
3. Track starting index of best window.
4. Print max sum and the winning window.
5. Validate invalid `k` values (`k <= 0` or `k > arr.length`).

### Expected Result

- Correct sliding-window update logic
- O(n) time complexity
- Proper input validation

### Deliverable

A Java class named `Task06MediumSlidingWindowMaxSum` with runnable `main`.

## Task 7 - Medium Level (Valid Parentheses Using Stack)

### Instructions

1. Read a string containing `()[]{}` characters.
2. Use `Stack<Character>` or `Deque<Character>` to validate brackets.
3. Return `true` only for properly nested and closed sequences.
4. Add helper method `isValid(String s)`.
5. Print validation result.

### Expected Result

- Correct LIFO bracket matching
- Correct handling of invalid closing brackets
- Correct final stack-empty check

### Deliverable

A Java class named `Task07MediumBracketValidatorStack` with runnable `main`.

## Task 8 - Medium Level (Word Frequency Map)

### Instructions

1. Start with a sentence string.
2. Normalize text to lowercase and remove punctuation.
3. Split into words and count frequency with `HashMap<String, Integer>`.
4. Print all words and counts.
5. Print the most frequent word.

### Expected Result

- Correct use of `HashMap`
- Proper text normalization
- Correct maximum-frequency logic

### Deliverable

A Java class named `Task08MediumWordFrequencyMap` with runnable `main`.

## Task 9 - Hard Level (Merge Intervals)

### Instructions

1. Represent intervals with `int[][]`.
2. Sort intervals by start time.
3. Merge overlapping intervals.
4. Print merged result.
5. Add method `merge(int[][] intervals)` returning merged intervals.

### Expected Result

- Correct sorting + merge flow
- No overlap in final output
- Clear interval output formatting

### Deliverable

A Java class named `Task09HardMergeIntervals` with runnable `main`.

## Task 10 - Hard Level (Binary Search on Answer Space)

### Instructions

1. Solve "minimum ship capacity within D days" style problem.
2. Use binary search over capacity range.
3. Write feasibility method `canShip(int[] weights, int days, int capacity)`.
4. Return minimal valid capacity.
5. Print result with test dataset.

### Expected Result

- Correct low/high boundaries
- Correct feasibility check
- Logarithmic search over answer space

### Deliverable

A Java class named `Task10HardBinarySearchCapacity` with runnable `main`.

## Task 11 - Hard Level (Number of Islands with DFS/BFS)

### Instructions

1. Use a 2D char grid containing `'1'` (land) and `'0'` (water).
2. Count islands using DFS or BFS.
3. Mark visited cells to avoid reprocessing.
4. Print island count.
5. Keep traversal logic in helper method.

### Expected Result

- Correct connected-component counting
- No repeated visits
- Stable boundary checks

### Deliverable

A Java class named `Task11HardNumberOfIslands` with runnable `main`.

## Task 12 - Hard Level (Pattern Interview Set)

### Instructions

1. Build one console class with a menu of 4 algorithms:
   - `1` Two Sum Sorted
   - `2` Max Sum Window
   - `3` Valid Parentheses
   - `4` Merge Intervals
   - `0` Exit
2. Route each option to its own method.
3. Keep menu in loop until user chooses exit.
4. Print time complexity line for the selected algorithm.
5. Handle invalid menu inputs gracefully.

### Expected Result

- Method decomposition by pattern
- Correct looped menu behavior
- Clear algorithm-complexity awareness

### Deliverable

A Java class named `Task12HardPatternInterviewSet` with runnable `main`.

## Final Submission

Submit the 12 Java classes and confirm each class runs from `main`.
