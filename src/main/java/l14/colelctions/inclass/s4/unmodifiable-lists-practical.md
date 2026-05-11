# Java-da Unmodifiable List-lər (Praktiki İzah)

## Unmodifiable List nədir?

`Unmodifiable List` dəyişdirilə bilməyən list-dir.  
Yəni `add`, `remove`, `set` kimi əməliyyatlar atılanda `UnsupportedOperationException` verir.

Bu, xüsusilə data-nı “read-only” paylaşmaq üçün lazımdır.

---

## 1) `List.of(...)` ilə unmodifiable list

```java
import java.util.List;

public class ListOfDemo {
    public static void main(String[] args) {
        List<String> roles = List.of("ADMIN", "TEACHER", "STUDENT");
        System.out.println(roles);

        roles.add("GUEST"); // UnsupportedOperationException
    }
}
```

Qeyd: `List.of(...)` həm unmodifiable-dir, həm də `null` qəbul etmir.

---

## 2) `Arrays.asList(...)` unmodifiable deyil (fixed-size list)

```java
import java.util.Arrays;
import java.util.List;

public class ArraysAsListDemo {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("A", "B", "C");

        items.set(1, "X"); // olar
        System.out.println(items); // [A, X, C]

        items.add("D");    // UnsupportedOperationException
        items.remove("A"); // UnsupportedOperationException
    }
}
```

Bu nüans tələbələr üçün vacibdir:
- `set` mümkündür
- ölçü dəyişən əməliyyatlar (`add/remove`) mümkün deyil

---

## 3) `Collections.unmodifiableList(...)` wrapper nümunəsi

```java
import java.util.*;

public class UnmodifiableWrapperDemo {
    public static void main(String[] args) {
        List<String> mutable = new ArrayList<>();
        mutable.add("Math");
        mutable.add("Physics");

        List<String> readOnly = Collections.unmodifiableList(mutable);
        System.out.println(readOnly); // [Math, Physics]

        // readOnly.add("Biology"); // UnsupportedOperationException

        mutable.add("Biology"); // original dəyişir
        System.out.println(readOnly); // [Math, Physics, Biology]
    }
}
```

Vacib məqam: bu “snapshot” deyil, sadəcə read-only view-dir.

---

## 4) Həqiqi snapshot (tam təhlükəsiz read-only paylaşım)

```java
import java.util.*;

public class SnapshotDemo {
    public static void main(String[] args) {
        List<String> source = new ArrayList<>(List.of("Java", "SQL"));

        List<String> snapshot = List.copyOf(source); // immutable snapshot
        System.out.println(snapshot); // [Java, SQL]

        source.add("Spring");
        System.out.println(source);   // [Java, SQL, Spring]
        System.out.println(snapshot); // [Java, SQL] (dəyişmir)
    }
}
```

`List.copyOf(...)` real read-only snapshot üçün çox uyğundur.

---

## Real-world istifadə halları

1. `getSubjects()` kimi metodda daxili list-i qorumaq.
2. Config və sabit reference data paylaşmaq.
3. API layer-də client-ə read-only kolleksiya qaytarmaq.

---

## Tələbələr üçün qısa qayda

1. Tam immutable list üçün:
   - `List.of(...)`
   - `List.copyOf(...)`
2. Mövcud mutable list-i read-only göstərmək üçün:
   - `Collections.unmodifiableList(list)`
3. `Arrays.asList(...)` immutable deyil, fixed-size-dir.

## Müsahibə tipli sual

`Collections.unmodifiableList(list)` ilə `List.copyOf(list)` fərqi:

- `unmodifiableList`: original dəyişərsə view də dəyişir.
- `copyOf`: yeni immutable copy yaradır, original dəyişsə də bu dəyişmir.
