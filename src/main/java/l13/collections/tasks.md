# Lesson 13 Practical Tasks - Collections (Use Cases and Advanced Practice)

## Objective

The goal of this assignment is to apply Java Collections in realistic scenarios: sorting, searching, indexing, grouping, prioritization, and collection selection by use case.

By completing these tasks, students will strengthen practical decision-making between `List`, `Set`, `Map`, `Queue`, `Deque`, and sorted collections.

## Project Structure Requirement

Each task must have its own package, and each task may be implemented with multiple classes.

```text
src/main/java/l13/homework/task01/
src/main/java/l13/homework/task02/
...
src/main/java/l13/homework/task12/
```

Suggested runnable class naming:

```text
Task01Main.java
Task02Main.java
...
Task12Main.java
```

## Task 1 - Easy Level (Collection Type Selection Drill)

### Instructions

1. Create one example each for `List`, `Set`, and `Map`.
2. Use the same domain (for example, student names).
3. Print why each structure is used in that case.

### Expected Result

- Correct structure selection
- Clear behavior comparison
- Better collection intuition

### Deliverable

Package `l13.homework.task01` with runnable `Task01Main`.

## Task 2 - Easy Level (ArrayList vs LinkedList Insert Pattern)

### Instructions

1. Build two collections with same initial data:
   - `ArrayList<Integer>`
   - `LinkedList<Integer>`
2. Insert elements at start/middle/end.
3. Print final order and operation notes.

### Expected Result

- Correct mutation operations
- Practical understanding of insertion patterns
- Clean comparative output

### Deliverable

Package `l13.homework.task02` with runnable `Task02Main`.

## Task 3 - Easy Level (HashSet vs LinkedHashSet vs TreeSet)

### Instructions

1. Use the same set of strings in:
   - `HashSet`
   - `LinkedHashSet`
   - `TreeSet`
2. Print each output order.
3. Explain ordering difference in comments.

### Expected Result

- Correct understanding of set ordering behavior
- Practical comparison of three set types
- Duplicate-free storage confirmation

### Deliverable

Package `l13.homework.task03` with runnable `Task03Main`.

## Task 4 - Easy Level (Map Variants Ordering)

### Instructions

1. Store same key-value pairs in:
   - `HashMap`
   - `LinkedHashMap`
   - `TreeMap`
2. Print iteration order for each.
3. Add one update operation and one removal operation.

### Expected Result

- Map ordering differences understood
- Basic update/remove operations
- Correct key-based behavior

### Deliverable

Package `l13.homework.task04` with runnable `Task04Main`.

## Task 5 - Medium Level (Priority Queue Task Scheduler)

### Instructions

1. Create class `TaskItem` with fields `title`, `priority`.
2. Use `PriorityQueue<TaskItem>` with comparator by priority.
3. Add at least 7 tasks with mixed priorities.
4. Poll and print execution order.

### Expected Result

- Priority-based processing flow
- Comparator-driven queue behavior
- Clear scheduler simulation

### Deliverable

Package `l13.homework.task05` with classes + runnable `Task05Main`.

## Task 6 - Medium Level (Deque for Browser History)

### Instructions

1. Use two stacks (via `Deque<String>`) for:
   - back history
   - forward history
2. Implement methods:
   - `visit(page)`
   - `back()`
   - `forward()`
3. Simulate at least 10 actions in `Task06Main`.

### Expected Result

- Correct navigation state management
- Practical `Deque` usage
- Stable behavior across transitions

### Deliverable

Package `l13.homework.task06` with multiple classes and runnable `Task06Main`.

## Task 7 - Medium Level (Top-N Elements Tracker)

### Instructions

1. Given integer scores, keep only top 5 values seen so far.
2. Use `PriorityQueue<Integer>` (min-heap strategy).
3. After each insert, print current top set.

### Expected Result

- Efficient top-N tracking logic
- Heap-based bounded structure usage
- Incremental results visibility

### Deliverable

Package `l13.homework.task07` with runnable `Task07Main`.

## Task 8 - Medium Level (Grouping with Map<List>)

### Instructions

1. Create class `Product` with fields `name`, `category`, `price`.
2. Group products by category using `Map<String, List<Product>>`.
3. Print grouped output and category counts.

### Expected Result

- Correct grouping logic
- Multi-value map structure mastery
- Clear domain-oriented output

### Deliverable

Package `l13.homework.task08` with classes + runnable `Task08Main`.

## Task 9 - Hard Level (Index + Search Service)

### Instructions

1. Create `Book` class (`id`, `title`, `author`, `tags`).
2. Build `BookIndexService` with:
   - `Map<Integer, Book>` by id
   - `Map<String, List<Book>>` by author
   - `Map<String, Set<Book>>` by tag
3. Add search methods for each index.
4. In `Task09Main`, test all index types.

### Expected Result

- Multi-index collection design
- Fast lookup by different keys
- Service-oriented architecture

### Deliverable

Package `l13.homework.task09` with multiple classes and runnable `Task09Main`.

## Task 10 - Hard Level (Custom LRU Cache)

### Instructions

1. Implement `LruCache<K, V>` using `LinkedHashMap`.
2. Define max capacity in constructor.
3. Override eviction behavior to remove eldest entry.
4. In `Task10Main`, demonstrate put/get and automatic eviction.

### Expected Result

- Practical `LinkedHashMap` advanced usage
- Capacity-bound cache behavior
- Correct eviction policy

### Deliverable

Package `l13.homework.task10` with classes + runnable `Task10Main`.

## Task 11 - Hard Level (Leaderboard with TreeSet + Comparator)

### Instructions

1. Create `PlayerScore` (`player`, `score`, `timestamp`).
2. Store in `TreeSet<PlayerScore>` sorted by:
   - score descending
   - timestamp ascending
   - player name as tiebreaker
3. Print top 10 and implement score update flow.

### Expected Result

- Complex comparator design
- Sorted unique ranking maintenance
- Deterministic ordering

### Deliverable

Package `l13.homework.task11` with multiple classes and runnable `Task11Main`.

## Task 12 - Hard Level (Collection-Driven Mini Commerce Backend)

### Instructions

1. Build mini backend with:
   - `Map<Integer, Customer>`
   - `Map<Integer, Product>`
   - `Map<Integer, List<Order>>` orders by customer
   - `PriorityQueue<Order>` for urgent orders
2. Required operations:
   - register customer
   - add product
   - create order
   - list customer orders
   - process urgent queue
3. In `Task12Main`, run at least 3 realistic scenarios.

### Expected Result

- End-to-end multi-collection architecture
- Strong collection choice by problem type
- Clear separation of data and service logic

### Deliverable

Package `l13.homework.task12` with multiple classes and runnable `Task12Main`.

## Final Submission

Submit all 12 task packages and confirm each `TaskXXMain` class runs from `main`.
