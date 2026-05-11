# Java `record` - Sıfırdan Advanced Səviyyəyə Qədər

Bu material tələbələr üçün hazırlanıb: `record` mövzusunu əsas səviyyədən başlayıb peşəkar istifadəyə qədər izah edir.

## 1) `record` nədir?

`record` Java-da məlumat daşıyan obyektləri qısa və təhlükəsiz yazmaq üçün istifadə olunan sinif növüdür.

Sadə desək:
- sahələri (`field`) elan edirsiniz;
- Java avtomatik olaraq konstruktoru, accessor metodları, `equals`, `hashCode`, `toString` yaradır.

```java
public record Student(String name, int age) {}
```

---

## 2) Niyə `record` istifadə olunur?

Ən böyük üstünlük: lazımsız təkrari kodu (boilerplate) azaldır.

Ənənəvi class-da eyni model üçün uzun kod yazılırdı:
- `private final` sahələr
- konstruktor
- getter-lər
- `equals/hashCode/toString`

`record` bunu bir sətirdə verir.

---

## 3) `record` avtomatik nə yaradır?

`record Student(String name, int age)` üçün:

1. `private final` sahələr
2. canonical konstruktor: `Student(String name, int age)`
3. accessor metodları:
   - `name()`
   - `age()`
4. `equals()`
5. `hashCode()`
6. `toString()`

Qeyd: getter adı `getName()` deyil, `name()` olur.

---

## 4) Compact konstruktor (validation üçün)

Məlumatı yaratmazdan əvvəl yoxlama etmək üçün compact konstruktor yazılır.

```java
public record User(String username, String email, int age) {
    public User {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("username boş ola bilməz");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("email formatı yanlışdır");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("yaş aralıqdan kənardır");
        }
    }
}
```

---

## 5) Əlavə konstruktor yazmaq

```java
public record Money(String currency, long amountInCents) {
    public Money(String currency) {
        this(currency, 0L);
    }
}
```

Qayda: əlavə konstruktor sonda canonical konstruktora `this(...)` ilə getməlidir.

---

## 6) `record` daxilində metod yazmaq

```java
public record Rectangle(double width, double height) {
    public double area() {
        return width * height;
    }
}
```

Yəni `record` yalnız data deyil, faydalı davranış metodları da saxlaya bilər.

---

## 7) `static` sahə və metod

```java
public record ApiResult(int code, String message) {
    public static final ApiResult OK = new ApiResult(200, "OK");

    public static ApiResult error(String message) {
        return new ApiResult(500, message);
    }
}
```

---

## 8) `record` məhdudiyyətləri

1. `record` implicit olaraq `final`-dır.
2. Başqa class-dan `extends` edə bilməz.
3. Sahələr faktiki olaraq dəyişməzdir (`final`).
4. Component-lərdən kənar instans sahə əlavə etmək olmaz.

---

## 9) Vacib məqam: dərin immutable deyil (shallow immutability)

Bu model təhlükəli ola bilər:

```java
import java.util.List;

public record Course(String title, List<String> topics) {}
```

`topics` xaricdə dəyişərsə, record daxilində də dəyişiklik görünər.

Düzgün yanaşma:

```java
import java.util.List;

public record Course(String title, List<String> topics) {
    public Course {
        topics = List.copyOf(topics); // defensive copy
    }
}
```

---

## 10) `equals/hashCode` davranışı

`record` dəyər-bazalı müqayisə verir:

```java
public record Point(int x, int y) {}

Point p1 = new Point(1, 2);
Point p2 = new Point(1, 2);

System.out.println(p1.equals(p2)); // true
```

---

## 11) Collections ilə istifadəsi

`record` `Map` üçün açar (`key`) kimi çox uyğundur:

```java
import java.util.HashMap;
import java.util.Map;

public record ProductKey(String sku, String region) {}

Map<ProductKey, Integer> stock = new HashMap<>();
stock.put(new ProductKey("SKU-1", "AZ"), 12);
```

---

## 12) Nested və local `record`

Nested:

```java
public class ReportService {
    public record Row(String label, long count) {}
}
```

Local:

```java
public class Demo {
    void run() {
        record Tmp(int id, String name) {}
        Tmp t = new Tmp(1, "A");
        System.out.println(t);
    }
}
```

---

## 13) Pattern matching ilə `record` (advanced)

```java
public record OrderEvent(String orderId, String status) {}

Object obj = new OrderEvent("ORD-1", "PAID");

if (obj instanceof OrderEvent(String orderId, String status)) {
    System.out.println(orderId + " -> " + status);
}
```

Bu yanaşma deconstruction üçün çox rahatdır.

---

## 14) `sealed` + `record` modeli

```java
public sealed interface PaymentResult permits Success, Failure {}

public record Success(String txId) implements PaymentResult {}
public record Failure(String reason) implements PaymentResult {}
```

Bu model daha təhlükəsiz tip iyerarxiyası qurmağa kömək edir.

---

## 15) Harada istifadə etmək düzgündür?

Uyğundur:
1. DTO-lar (request/response)
2. Event obyektləri
3. Query nəticə modelləri
4. Value object-lər (`Money`, `Range`, `Coordinate`)

Diqqətli olmaq lazımdır:
1. JPA entity-lərdə
2. Dəyişən state tələb edən aggregate-lərdə

---

## 16) `record` vs `class` vs Lombok

- `record`: qısa, standart, value-semantics hazır.
- `class`: daha çevik, kompleks davranış üçün əlverişli.
- Lombok: boilerplate azaldır, amma dil səviyyəsində standart deyil.

---

## 17) Spring/Jackson ilə istifadə

Müasir Jackson versiyalarında `record` dəstəklənir:

```java
public record CreateUserRequest(String username, String email) {}
public record CreateUserResponse(String userId, String status) {}
```

REST API-lərdə çox rahat işləyir.

---

## 18) Validation annotasiyaları ilə

```java
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record RegisterRequest(
        @NotBlank String username,
        @Email String email,
        @Positive int age
) {}
```

---

## 19) Real nümunə (checkout response)

```java
import java.math.BigDecimal;
import java.time.Instant;

public record CheckoutResponse(
        String orderId,
        BigDecimal total,
        String currency,
        String status,
        Instant createdAt
) {
    public CheckoutResponse {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("orderId boş ola bilməz");
        }
        if (total == null || total.signum() < 0) {
            throw new IllegalArgumentException("məbləğ mənfi ola bilməz");
        }
    }
}
```

---

## 20) Best practice-lər

1. `record`-u data carrier üçün istifadə et.
2. `List`/`Map` kimi mutable tiplərdə `copyOf` et.
3. Validation-u konstruktor səviyyəsində et.
4. Component adlarını mənalı seç (`userId`, `createdAt`, `status`).

---

## 21) Tələbələrin tez-tez etdiyi səhvlər

1. `record`-u JPA entity kimi məcburi istifadə etmək.
2. Defensive copy etməmək.
3. Getter adını `getX()` gözləmək.
4. Inheritance gözləmək (`record` final-dır).

---

## 22) Praktik tapşırıqlar

1. `StudentRecord(name, gpa)` yaz, GPA üçün range validation et.
2. `Money(currency, amount)` yaz, mənfi məbləği blokla.
3. `Course(title, topics)` yaz, `List.copyOf` tətbiq et.
4. `sealed` + `record` ilə nəticə modeli qur (`Success/Failure`).
5. API request/response record-ları yarat və annotasiya ilə validate et.

---

## 23) Yekun

`record` Java-da müasir, yığcam və etibarlı məlumat modelləri yaratmaq üçün çox güclü vasitədir.  
Düzgün validation və immutable yanaşma ilə kod həm sadələşir, həm də daha təhlükəsiz olur.

---

## 24) Bu fayldakı nümunələri necə run etmək olar?

Bu `md` faylına uyğun runnable class-lar yaradılıb:

- `l14.colelctions.inclass.s7.RecordDemo01Basic`
- `l14.colelctions.inclass.s7.RecordDemo02Validation`
- `l14.colelctions.inclass.s7.RecordDemo03ConstructorsAndMethods`
- `l14.colelctions.inclass.s7.RecordDemo04DefensiveCopy`
- `l14.colelctions.inclass.s7.RecordDemo05EqualsHashCodeMapKey`
- `l14.colelctions.inclass.s7.RecordDemo06NestedLocalPattern`
- `l14.colelctions.inclass.s7.RecordDemo07SealedRecords`
- `l14.colelctions.inclass.s7.RecordDemo08RealWorldCheckout`
- `l14.colelctions.inclass.s7.RecordLessonRunner` (hamısını ardıcıl işə salır)

Terminaldan:

```bash
cd /Users/aqilaghamirzayev/Desktop/Projects/real-self/course02
mvn -q -DskipTests compile
java -cp target/classes l14.colelctions.inclass.s7.RecordLessonRunner
```

Tək-tək run etmək üçün nümunə:

```bash
java -cp target/classes l14.colelctions.inclass.s7.RecordDemo04DefensiveCopy
```
