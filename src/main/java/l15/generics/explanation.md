# Lesson 15: Generics and Wildcards (Java)

This lesson explains how to design safer APIs using generics and wildcards, and how to migrate legacy raw-type code to modern typed code.

## Learning Objectives

By the end of this lesson, students should be able to:

- Explain how generics prevent runtime type bugs at compile time
- Write and use generic classes and generic methods
- Use wildcard forms correctly: `?`, `? extends T`, `? super T`
- Apply the PECS rule in API design (`Producer Extends, Consumer Super`)
- Refactor raw-type collection code into type-safe generic code

## 1. Why Generics Matter for Type Safety

Before Java 5, collections stored `Object`, so mistakes were found at runtime:

```java
List users = new ArrayList(); // raw type
users.add("Alice");
users.add(42); // accidental wrong type

String name = (String) users.get(1); // ClassCastException at runtime
```

With generics, the compiler prevents invalid inserts:

```java
List<String> users = new ArrayList<>();
users.add("Alice");
// users.add(42); // compile-time error
```

Real-world impact:

- Payment services avoid accidental mixing of `PaymentEvent` and `RefundEvent` in the same pipeline
- Healthcare systems avoid mixing `Patient` and `Doctor` records in one list
- Log analytics avoids runtime crashes caused by unexpected data shapes

Core idea: generics move failures from production runtime to compile-time.

## 2. Generic Classes and Generic Methods

### 2.1 Generic Class Example

```java
public class Box<T> {
    private T value;

    public void set(T value) { this.value = value; }
    public T get() { return value; }
}
```

Usage:

```java
Box<String> tokenBox = new Box<>();
tokenBox.set("jwt-token");

Box<Integer> retryBox = new Box<>();
retryBox.set(3);
```

Real-world pattern:

- `Box<Order>` for queue items
- `Box<Config>` for lazy-loaded configuration
- `Box<Session>` for thread-local context wrappers

### 2.2 Generic Method Example

```java
public static <T> T firstNonNull(T first, T second) {
    return first != null ? first : second;
}
```

Usage:

```java
String region = firstNonNull(envRegion, "eu-west-1");
Integer retry = firstNonNull(userRetry, 3);
```

Real-world pattern:

- Fallback resolution (`userValue -> tenantDefault -> globalDefault`)
- Cache helpers (`getOrCompute<T>`)
- Data transformation utilities (`map<T, R>`)

## 3. Wildcards: `?`, `? extends`, `? super`

### 3.1 `?` (Unbounded Wildcard)

Use when type parameter is unknown and you only need `Object`-level operations.

```java
public static void printAnyList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}
```

Good fit:

- Debugging/logging utilities
- Generic table renderers
- Monitoring hooks

### 3.2 `? extends T` (Upper-Bounded Wildcard)

Use when the parameter is a producer of `T` values.

```java
public static double sumPrices(List<? extends Number> prices) {
    double total = 0;
    for (Number p : prices) total += p.doubleValue();
    return total;
}
```

Can read as `T`, cannot safely add new values (except `null`).

Good fit:

- Aggregation (`sum`, `average`, `max`)
- Reporting input (`List<SalesRecord>`, `List<DiscountedSalesRecord>`)
- Analytics pipelines

### 3.3 `? super T` (Lower-Bounded Wildcard)

Use when the parameter consumes `T` values.

```java
public static void enqueueDefaults(List<? super Notification> queue) {
    queue.add(new Notification("Welcome"));
    queue.add(new Notification("Verify email"));
}
```

Can safely add `T` values; when reading, type is `Object`.

Good fit:

- Writing to queues/buffers
- Callback/event sinks
- Batch-output collectors

## 4. PECS Rule for Producer/Consumer APIs

PECS means:

- Producer -> `extends`
- Consumer -> `super`

Canonical API:

```java
public static <T> void copy(List<? extends T> src, List<? super T> dst) {
    for (T item : src) {
        dst.add(item);
    }
}
```

Real-world examples:

- Copy `List<InvoiceLine>` into `List<AccountingEntry>`
- Copy `List<AdminUser>` into `List<User>`
- Move validated DTOs into broader persistence command queues

Design checklist:

- If the method reads from collection -> prefer `extends`
- If the method writes to collection -> prefer `super`
- If both read and write same collection -> use exact type `List<T>` (no wildcard)

## 5. Refactoring Raw-Type Code into Generic Code

### 5.1 Legacy Raw-Type Version

```java
Map cache = new HashMap();
cache.put("timeout", 30);
cache.put("mode", "SAFE");

Integer timeout = (Integer) cache.get("timeout");
```

Problems:

- No compile-time guarantee per key/value type
- Frequent manual casts
- Hidden runtime exceptions

### 5.2 Generic Refactor

```java
Map<String, Object> cache = new HashMap<>();
cache.put("timeout", 30);
cache.put("mode", "SAFE");
```

Better refactor for strict typing:

```java
record Config(int timeout, String mode) {}

Config config = new Config(30, "SAFE");
```

Practical migration strategy:

1. Add type arguments to collection declarations.
2. Replace raw method signatures with generic ones.
3. Compile with `-Xlint:unchecked` and remove warnings one by one.
4. Introduce domain types (`record`, DTO, wrapper class) to eliminate `Object`.

## 6. Common Mistakes to Teach

- Mistake: assuming `List<Integer>` is a subtype of `List<Number>` (it is not)
- Mistake: returning wildcard types from public APIs
- Mistake: using raw types in new code
- Mistake: overusing `<?>` when method needs stronger constraints

## 7. Classroom Demo Flow (Recommended)

1. Show raw-type bug (`ClassCastException`)
2. Convert to `List<String>` and show compile-time protection
3. Introduce `? extends` with aggregation demo
4. Introduce `? super` with queue writer demo
5. Implement `copy(src, dst)` and ask students to explain why PECS works

## 8. Summary

Generics are primarily about correctness and maintainability.

- `T` gives reusable, type-safe APIs
- `? extends T` reads from producers
- `? super T` writes into consumers
- PECS helps choose wildcard direction fast
- Raw-type refactoring removes hidden runtime failures
