# Lesson 15 Resources: Generics and Wildcards

## A) Official Java Documentation (Primary)

- Dev.java Generics overview: https://dev.java/learn/generics/
- Dev.java Wildcards (`?`, `extends`, `super`, capture, guidelines): https://dev.java/learn/generics/wildcards/
- Dev.java Type Erasure: https://dev.java/learn/generics/type-erasure/
- JLS Chapter 4 (Types, parameterized types, wildcards, raw types, erasure): https://docs.oracle.com/javase/specs/jls/se21/html/jls-4.html
- Java Language Guide on Generics (Oracle): https://docs.oracle.com/javase/8/docs/technotes/guides/language/generics.html

## B) API Docs to Show Real PECS in the JDK

- `Collection.addAll(Collection<? extends E>)`: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Collection.html
- `Collections.copy(List<? super T>, List<? extends T>)`: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Collections.html
- `Comparator.naturalOrder()` and wildcard-heavy comparator APIs: https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/Comparator.html

## C) Book References (Excellent for Instructors)

- Effective Java, 3rd Edition (Joshua Bloch)
  - Item 26: Don’t use raw types
  - Item 28: Prefer lists to arrays
  - Item 31: Use bounded wildcards to increase API flexibility
- Java Generics and Collections (Maurice Naftalin, Philip Wadler)

## D) Suggested Teaching Sequence

1. Start from runtime bug caused by raw types.
2. Add generic type parameters and remove casts.
3. Introduce wildcard variance (`extends` vs `super`).
4. Teach PECS with `Collections.copy` signature.
5. Close with JLS/erasure restrictions and practical API design rules.

## E) Quick Classroom Prompts

- Why is `List<Integer>` not a subtype of `List<Number>`?
- Which parameter in `copy(src, dst)` is producer and which is consumer?
- What warnings appear with `-Xlint:unchecked` and how do we eliminate them?
- Why can’t Java know `List<String>` element type fully at runtime?
