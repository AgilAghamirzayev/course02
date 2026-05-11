# Java Collections: Fail-Fast vs Fail-Safe (Praktiki Nümunələr)

## Qısa anlayış

- **Fail-Fast**: Iterasiya zamanı collection strukturca dəyişərsə, dərhal `ConcurrentModificationException` atır.
- **Fail-Safe**: Iterasiya “snapshot” və ya concurrent mexanizmlə işləyir, ona görə paralel dəyişiklikdə exception atmır.

---

## 1) Fail-Fast nümunə (`ArrayList`)

```java
import java.util.*;

public class FailFastArrayListDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Ali", "Veli", "Aynur"));

        for (String n : names) {
            if (n.equals("Veli")) {
                names.add("Nigar"); // struktur dəyişikliyi
            }
        }
    }
}
```

Gözlənilən nəticə: `ConcurrentModificationException`.

---

## 2) Fail-Fast nümunə (`HashMap`)

```java
import java.util.*;

public class FailFastHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Book");
        map.put(2, "Pen");
        map.put(3, "Notebook");

        for (Integer key : map.keySet()) {
            if (key == 2) {
                map.put(4, "Pencil"); // iterasiya zamanı struktur dəyişir
            }
        }
    }
}
```

Gözlənilən nəticə: `ConcurrentModificationException`.

---

## 3) Fail-Fast collection ilə düzgün silmə (`Iterator.remove`)

```java
import java.util.*;

public class SafeRemoveWithIteratorDemo {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) {
            Integer x = it.next();
            if (x % 2 == 0) {
                it.remove(); // düzgün yol
            }
        }

        System.out.println(nums); // [1, 3, 5]
    }
}
```

Praktik mesaj: `for-each` içində `list.remove(...)` etmə, iteratorun `remove()`-unu istifadə et.

---

## 4) Fail-Safe nümunə (`CopyOnWriteArrayList`)

```java
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeCopyOnWriteDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list =
                new CopyOnWriteArrayList<>(new String[]{"A", "B", "C"});

        for (String s : list) {
            if (s.equals("B")) {
                list.add("D"); // exception atmır
            }
        }

        System.out.println(list); // [A, B, C, D]
    }
}
```

Nəticə: Exception olmur, çünki iterator snapshot üzərində gəzir.

---

## 5) Fail-Safe/concurrent nümunə (`ConcurrentHashMap`)

```java
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Order-1");
        map.put(2, "Order-2");
        map.put(3, "Order-3");

        for (Integer k : map.keySet()) {
            if (k == 2) {
                map.put(4, "Order-4"); // iterasiya zamanı update
            }
        }

        System.out.println(map); // exception yoxdur
    }
}
```

Nəticə: Concurrent işləmə üçün daha uyğundur, fail-fast kimi dərhal partlamır.

---

## Dərsdə tələbələrə praktik qayda

1. Tək thread, sadə list/map: `ArrayList`, `HashMap` normaldır.
2. Iterasiya zamanı silmək lazımdırsa: `Iterator.remove()`.
3. Paralel oxu-yazı çoxdursa:
   - list üçün `CopyOnWriteArrayList`
   - map üçün `ConcurrentHashMap`
4. `ConcurrentModificationException` görürsənsə, bu çox vaxt fail-fast davranışıdır.

## Real-world mapping

- `Fail-Fast`: developer bug-ları erkən tutmaq üçün yaxşıdır.
- `Fail-Safe/Concurrent`: chat, order queue, event processing kimi çox-thread mühitdə daha praktikdir.
