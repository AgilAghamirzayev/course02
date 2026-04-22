# Lesson 12 Practical Tasks - Collections Part 1

## Objective

The goal of this assignment is to practice Java Collections fundamentals using `List`, `Set`, `Map`, `Queue`, iterators, comparators, and simple custom collection logic.

By completing these tasks, students will improve data modeling, collection operations, and clean collection-oriented design.

## Project Structure Requirement

Each task must have its own package, and tasks may include multiple classes.

```text
src/main/java/l12/homework/task01/
src/main/java/l12/homework/task02/
...
src/main/java/l12/homework/task12/
```

Suggested runnable class naming:

```text
Task01Main.java
Task02Main.java
...
Task12Main.java
```

## Task 1 - Easy Level (ArrayList Basics)

### Instructions

1. Create `ArrayList<String>` for student names.
2. Add at least 6 names.
3. Print size, first element, last element.
4. Remove one name and print final list.

### Expected Result

- Correct `ArrayList` creation and mutation
- Basic index-based access
- Clear before/after output

### Deliverable

Package `l12.homework.task01` with runnable `Task01Main`.

## Task 2 - Easy Level (LinkedList Queue Style)

### Instructions

1. Create `LinkedList<String>` as task queue.
2. Add tasks using `addLast`.
3. Process tasks using `pollFirst` in loop.
4. Print processed order.

### Expected Result

- Queue-like behavior with `LinkedList`
- FIFO order understanding
- Empty-safe processing loop

### Deliverable

Package `l12.homework.task02` with runnable `Task02Main`.

## Task 3 - Easy Level (HashSet Uniqueness)

### Instructions

1. Create `HashSet<String>` and add repeated city names.
2. Print set content and size.
3. Verify duplicates are ignored.

### Expected Result

- Unique element storage behavior
- Basic set operations
- Clear duplicate handling proof

### Deliverable

Package `l12.homework.task03` with runnable `Task03Main`.

## Task 4 - Easy Level (HashMap Intro)

### Instructions

1. Create `HashMap<Integer, String>` for id-name pairs.
2. Add at least 5 entries.
3. Read one key, update one key, remove one key.
4. Print all entries using `entrySet`.

### Expected Result

- Basic CRUD operations on `Map`
- Correct key-based updates
- Iteration over entries

### Deliverable

Package `l12.homework.task04` with runnable `Task04Main`.

## Task 5 - Medium Level (List Filtering With Iterator)

### Instructions

1. Create `List<Integer>` with numbers 1..30.
2. Remove odd numbers using `Iterator`.
3. Print final even-only list.

### Expected Result

- Safe removal during iteration
- Correct `Iterator` usage
- Final filtered collection

### Deliverable

Package `l12.homework.task05` with runnable `Task05Main`.

## Task 6 - Medium Level (Sorting Objects)

### Instructions

1. Create class `Person` with fields `name`, `age`.
2. Build `List<Person>`.
3. Sort by age ascending with `Comparator`.
4. Sort by name descending with another comparator.
5. Print both results.

### Expected Result

- Object sorting with custom comparators
- Multiple sort criteria handling
- Readable ordered output

### Deliverable

Package `l12.homework.task06` with classes + runnable `Task06Main`.

## Task 7 - Medium Level (Frequency Counter with Map)

### Instructions

1. Given a sentence, split into words.
2. Count frequency using `Map<String, Integer>`.
3. Print each word and count.
4. Find and print most frequent word.

### Expected Result

- Real-world `Map` counting usage
- Merge/update pattern mastery
- Basic aggregation logic

### Deliverable

Package `l12.homework.task07` with runnable `Task07Main`.

## Task 8 - Medium Level (Stack and Queue Comparison)

### Instructions

1. Use `Deque<String>` as stack (`push`, `pop`).
2. Use another `Deque<String>` as queue (`offer`, `poll`).
3. Insert same items into both structures.
4. Print processing order for each.

### Expected Result

- LIFO vs FIFO behavior clarity
- Practical `Deque` API usage
- Correct operation method selection

### Deliverable

Package `l12.homework.task08` with runnable `Task08Main`.

## Task 9 - Hard Level (Custom Generic List)

### Instructions

1. Create interface `MyList<T>` with methods:
   - `void add(T item)`
   - `T get(int index)`
   - `int size()`
2. Implement `MyArrayList<T>` with internal array and resize logic.
3. In `Task09Main`, test with `String` and `Integer`.

### Expected Result

- Basic generic collection implementation
- Dynamic resize behavior
- Reusable type-safe design

### Deliverable

Package `l12.homework.task09` with multiple classes and runnable `Task09Main`.

## Task 10 - Hard Level (Custom Linked List)

### Instructions

1. Create generic `Node<T>` and `MyLinkedList<T>`.
2. Implement methods:
   - `addFirst(T item)`
   - `addLast(T item)`
   - `removeFirst()`
   - `printAll()`
3. In `Task10Main`, simulate multiple operations.

### Expected Result

- Node-based linked structure understanding
- Head/tail mutation handling
- Stable list operations

### Deliverable

Package `l12.homework.task10` with multiple classes and runnable `Task10Main`.

## Task 11 - Hard Level (Student Registry Service)

### Instructions

1. Create class `Student` (`id`, `name`, `grade`).
2. Create `StudentRegistry` using:
   - `Map<Integer, Student>` for lookup
   - `Set<String>` for unique class names
3. Add methods to register, update grade, find student, and list all.
4. In `Task11Main`, run realistic registry scenarios.

### Expected Result

- Combined use of `Map` + `Set`
- Service-style collection management
- Cleaner domain separation

### Deliverable

Package `l12.homework.task11` with multiple classes and runnable `Task11Main`.

## Task 12 - Hard Level (Mini Collection-Driven Console App)

### Instructions

1. Build mini library app with:
   - `List<Book>` for all books
   - `Set<String>` for categories
   - `Map<String, List<Book>>` for category index
2. Required operations:
   - add book
   - list all books
   - list by category
   - count books per category
3. In `Task12Main`, run at least 3 different scenarios.

### Expected Result

- End-to-end collections usage in one flow
- Multi-structure design and coordination
- Extendable mini app architecture

### Deliverable

Package `l12.homework.task12` with multiple classes and runnable `Task12Main`.

## Final Submission

Submit all 12 task packages and confirm each `TaskXXMain` class runs from `main`.
