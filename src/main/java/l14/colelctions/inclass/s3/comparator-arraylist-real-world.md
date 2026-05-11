# Java-da `ArrayList` + `Comparator` (Real-World İzah)

## `Comparator` nədir?

`Comparator<T>` obyektləri **xaricdən müqayisə edən** qaydadır.  
Class-ın içini dəyişmədən fərqli sıralama məntiqi yaza bilirik.

```java
Comparator<Student> byGpaDesc = (a, b) -> Double.compare(b.gpa, a.gpa);
```

## Niyə lazımdır?

Bir obyekt üçün bir neçə sıralama ehtiyacı olur:
- GPA-ya görə
- Ada görə
- Yaşa görə

`Comparable` bir natural order verir, `Comparator` isə çoxlu fərqli order verir.

---

## Real-World Example 1: Tələbələri fərqli kriteriyalara görə sıralamaq

```java
import java.util.*;

class Student {
    String name;
    double gpa;
    int age;

    Student(String name, double gpa, int age) {
        this.name = name;
        this.gpa = gpa;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " | gpa=" + gpa + " | age=" + age;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Aylin", 3.7, 20));
        list.add(new Student("Murad", 2.9, 19));
        list.add(new Student("Nigar", 3.9, 21));

        list.sort((a, b) -> Double.compare(b.gpa, a.gpa)); // GPA azalan
        System.out.println("By GPA desc: " + list);

        list.sort(Comparator.comparing(s -> s.name)); // Ada görə artan
        System.out.println("By name asc: " + list);
    }
}
```

İzah: Müəllim bəzən GPA ranking, bəzən əlifba sırası istəyir.

---

## Real-World Example 2: Məhsulları qiymətə və reytinqə görə sıralamaq

```java
import java.util.*;

class Product {
    String name;
    double price;
    double rating;

    Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + " | $" + price + " | rating=" + rating;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Mouse", 25, 4.4));
        products.add(new Product("Keyboard", 70, 4.8));
        products.add(new Product("Monitor", 220, 4.6));

        products.sort(Comparator.comparingDouble(p -> p.price)); // ucuzdan bahaya
        System.out.println("Price low->high: " + products);

        products.sort(Comparator.comparingDouble((Product p) -> p.rating).reversed()); // rating azalan
        System.out.println("Rating high->low: " + products);
    }
}
```

İzah: E-commerce saytında user filter seçiminə görə fərqli sıralama tətbiq olunur.

---

## Real-World Example 3: Namizədləri multi-level sort etmək

```java
import java.util.*;

class Candidate {
    String fullName;
    int experienceYears;
    double interviewScore;

    Candidate(String fullName, int experienceYears, double interviewScore) {
        this.fullName = fullName;
        this.experienceYears = experienceYears;
        this.interviewScore = interviewScore;
    }

    @Override
    public String toString() {
        return fullName + " | exp=" + experienceYears + " | score=" + interviewScore;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Candidate> c = new ArrayList<>();
        c.add(new Candidate("Rauf Aliyev", 4, 87.5));
        c.add(new Candidate("Leyla Mammadova", 4, 92.0));
        c.add(new Candidate("Orxan Hasanov", 6, 82.0));

        c.sort(
            Comparator.comparingInt((Candidate x) -> x.experienceYears).reversed()
                .thenComparing((Candidate x) -> x.interviewScore, Comparator.reverseOrder())
                .thenComparing(x -> x.fullName)
        );

        System.out.println(c);
    }
}
```

İzah: HR-də əvvəl təcrübə, eyni təcrübədə interview score, sonra ad ilə tie-break edilir.

---

## Tələbələr üçün qısa qayda

1. Class-ı dəyişmədən sıralama istəyirsənsə -> `Comparator`.
2. Müxtəlif sıralamalar lazımdırsa -> `Comparator` daha uyğundur.
3. Ən praktik çağırış:

```java
list.sort(comparator);
```

## `Comparable` vs `Comparator` (qısa)

- `Comparable`: class daxilində natural order (`compareTo`)
- `Comparator`: class xaricində alternativ order (`compare`)

Yəni dərsdə:  
`s2` -> `Comparable` (default sıralama),  
`s3` -> `Comparator` (fərqli business sıralamaları).
