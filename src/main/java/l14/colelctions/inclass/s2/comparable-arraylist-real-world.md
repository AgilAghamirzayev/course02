# Java-da `ArrayList` + `Comparable` (Real-World İzah)

## `Comparable` nədir?

`Comparable<T>` obyektin **öz təbii sıralanma qaydasını** müəyyən edir.  
Yəni class-ın içində `compareTo()` yazırıq və `Collections.sort(list)` çağıranda Java o qaydanı istifadə edir.

```java
class Student implements Comparable<Student> {
    @Override
    public int compareTo(Student other) {
        return 0;
    }
}
```

## Niyə `ArrayList` ilə birlikdə istifadə olunur?

`ArrayList` çox vaxt məlumat toplamaq üçün istifadə olunur (tələbələr, məhsullar, sifarişlər və s.).  
Sonra bu siyahını artan/azalan qaydada düzürük:

```java
Collections.sort(list);
```

Bu işləməsi üçün list-dəki obyektlər ya `Comparable` olmalıdır, ya da ayrıca `Comparator` verilməlidir.

---

## Real-World Example 1: Tələbələri GPA-ya görə sıralamaq

```java
import java.util.*;

class Student implements Comparable<Student> {
    String name;
    double gpa;

    Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.gpa, this.gpa); // yüksək GPA əvvəl
    }

    @Override
    public String toString() {
        return name + " - " + gpa;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Aylin", 3.7));
        students.add(new Student("Murad", 2.9));
        students.add(new Student("Nigar", 3.95));

        Collections.sort(students);
        System.out.println(students);
    }
}
```

İzah: Universitetdə dean’s list üçün ən yüksək GPA-lar yuxarıda olmalıdır.

---

## Real-World Example 2: Məhsulları qiymətə görə sıralamaq

```java
import java.util.*;

class Product implements Comparable<Product> {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price); // ucuzdan bahaya
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Mouse", 25));
        products.add(new Product("Keyboard", 70));
        products.add(new Product("Monitor", 220));

        Collections.sort(products);
        System.out.println(products);
    }
}
```

İzah: E-commerce saytında “Price: Low to High” filtri.

---

## Real-World Example 3: İş namizədlərini təcrübəyə görə sıralamaq

```java
import java.util.*;

class Candidate implements Comparable<Candidate> {
    String fullName;
    int yearsOfExperience;

    Candidate(String fullName, int yearsOfExperience) {
        this.fullName = fullName;
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public int compareTo(Candidate other) {
        return Integer.compare(other.yearsOfExperience, this.yearsOfExperience); // çox təcrübə əvvəl
    }

    @Override
    public String toString() {
        return fullName + " - " + yearsOfExperience + " years";
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("Rauf Aliyev", 2));
        candidates.add(new Candidate("Leyla Mammadova", 6));
        candidates.add(new Candidate("Orxan Hasanov", 4));

        Collections.sort(candidates);
        System.out.println(candidates);
    }
}
```

İzah: HR ilkin shortlist üçün yüksək təcrübəliləri yuxarıda görmək istəyir.

---

## Tələbələr üçün qısa qayda

1. Class-ın **default sıralanması** varsa -> `Comparable` yaz.
2. `compareTo()` metodu:
   - mənfi qaytarırsa: `this` əvvəl gəlir
   - 0 qaytarırsa: eyni sayılır
   - müsbət qaytarırsa: `other` əvvəl gəlir
3. Sıralamaq üçün:

```java
Collections.sort(list);
```

## `Comparable` vs `Comparator` (qısa fərq)

- `Comparable`: class daxilində 1 əsas natural order.
- `Comparator`: class-dan kənarda çoxlu fərqli sıralama qaydaları.

Məsələn `Student` üçün bir dəfə GPA-ya görə (`Comparable`), başqa vaxt ada görə (`Comparator`).
