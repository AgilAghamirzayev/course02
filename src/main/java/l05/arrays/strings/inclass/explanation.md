# Lesson 5: Arrays and Strings (Java)

This lesson moves from single values to collections and text processing.
You will learn how to store many values in arrays, process them with loops and methods, and work with strings safely and efficiently.

## In-class Coverage

- [ ] 1D arrays: declaration, default values, indexing, and traversal
- [ ] Array calculations: sum, average, min, and sorting
- [ ] 2D and 3D arrays for table-like and cube-like data
- [ ] String creation models (`literal`, `new String`, `char[]`)
- [ ] String pool, `==` vs `.equals`, and `intern()`
- [ ] Core String API methods for search, slicing, formatting, and cleanup

## Learning Objectives

By the end of this lesson, students will be able to:

- Create and initialize 1D, 2D, and 3D arrays
- Traverse arrays with correct boundaries (`i < arr.length`)
- Compute sum, average, min/max, and sorted output from arrays
- Explain why cloning is needed when sorting without changing original data
- Model real data with multidimensional arrays
- Compare strings correctly with `.equals(...)`
- Explain String pool behavior and when `intern()` changes references
- Use common String APIs for real console tasks

## 1. One-Dimensional Arrays

### 1.1 Declaration and Default Values

```java
int[] nums = new int[10];
```

- `nums` stores 10 integers
- each element starts with default value `0`
- valid indices are `0` to `9`

### 1.2 Indexing and Updates

```java
nums[0] = 1;
nums[7] = 100;
```

Each index is a separate memory slot. Access outside the range causes `ArrayIndexOutOfBoundsException`.

### 1.3 Traversal Pattern

```java
for (int i = 0; i < nums.length; i++) {
    System.out.printf("%d -> %d%n", i, nums[i]);
}
```

Always prefer `nums.length` over hardcoded sizes.

## 2. Array Construction with Logic

You can build array contents through loop rules.

Example: fill an array with odd numbers.

```java
int[] nums = new int[100];
int counter = 0;

for (int index = 0; index < nums.length; counter++) {
    if (counter % 2 == 1) {
        nums[index] = counter;
        index++;
    }
}
```

This pattern separates:

- source value generator (`counter`)
- storage position (`index`)

## 3. Array Analytics with Methods

Given an array like:

```java
int[] ages = {18, 25, 30, 16, 22, 40, 19};
```

Common operations:

- sum with accumulator
- average (`sum / length`)
- minimum with comparison
- sorting with nested loops (bubble sort)

### 3.1 Clone Before Sort

```java
int[] sortedAges = sortAges(ages.clone());
```

`clone()` prevents accidental mutation of original data.

### 3.2 Bubble Sort Idea

Use two loops and swap adjacent elements when left is greater than right.

```java
for (int i = 0; i < arr.length - 1; i++) {
    for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
```

## 4. Two-Dimensional Arrays

2D arrays store tabular data (rows x columns).

```java
int[][] nums = new int[2][3];
nums[0][1] = 7;
```

Print options:

- quick debug: `Arrays.deepToString(nums)`
- structured traversal: nested loops

```java
for (int i = 0; i < nums.length; i++) {
    for (int j = 0; j < nums[i].length; j++) {
        System.out.print(nums[i][j] + " ");
    }
    System.out.println();
}
```

## 5. Three-Dimensional Arrays

3D arrays are useful for layered datasets.

Example model:

- dimension 1: students
- dimension 2: subjects
- dimension 3: semesters

```java
int[][][] studentArray = new int[students][subjects][semesters];
```

Typical tasks:

- print all marks
- compute average per student
- find best subject per student

This combines nested loops and method decomposition for readability.

## 6. String Basics

### 6.1 String vs char[]

```java
String name = "John";
char[] chars = {'J', 'o', 'h', 'n'};
```

- `String` is immutable object
- `char[]` is mutable character array

### 6.2 Construction Styles

```java
String a = "Test";              // string pool literal
String b = new String("Test");  // new heap object
```

These may have same content but different references.

## 7. `==`, `.equals`, and String Pool

### 7.1 Reference vs Content

- `==` compares object references
- `.equals(...)` compares text content

```java
System.out.println(name1 == name2);       // reference compare
System.out.println(name1.equals(name2));  // content compare
```

### 7.2 `intern()`

`intern()` returns pooled reference for that content.

```java
String pooled = new String("Test").intern();
```

Use this only when you clearly need pool reference behavior.

## 8. Core String API Toolkit

Common methods from in-class practice:

- `length()`
- `charAt(index)`
- `indexOf(...)`
- `substring(begin, end)`
- `toUpperCase()`, `toLowerCase()`
- `equals(...)`, `equalsIgnoreCase(...)`
- `startsWith(...)`, `endsWith(...)`, `contains(...)`
- `replace(...)`
- `isEmpty()`, `isBlank()`
- `trim()`, `strip()`, `stripLeading()`, `stripTrailing()`
- `split(...)`, `String.join(...)`
- `String.format(...)`, `"template".formatted(...)`

## 9. Common Mistakes Checklist

- Using `i <= arr.length` instead of `i < arr.length`
- Forgetting array default values when expecting manual initialization
- Sorting original array when a copy was required
- Comparing strings with `==` in business logic
- Using `charAt` with invalid index
- Assuming `substring` end index is inclusive (it is exclusive)
- Confusing `isEmpty()` with `isBlank()`

## 10. Mini Practice Tasks

1. Build an array of size 20 and fill it with even numbers.
2. Read `N` scores into an array and print sum + average.
3. Find min and max values in an integer array.
4. Sort an array ascending without using `Arrays.sort`.
5. Print a 2D matrix and compute each row sum.
6. Model student marks with a 3D array and print average per student.
7. Show outputs of `==` and `.equals` for literal/new String combinations.
8. Parse a CSV string with `split`, then rebuild using `String.join`.

## 11. Summary

Arrays help you manage collections of structured values.
Strings help you process and validate text-based input and output.
When you combine loops, methods, and correct comparison rules, your programs become more reliable and easier to maintain.
