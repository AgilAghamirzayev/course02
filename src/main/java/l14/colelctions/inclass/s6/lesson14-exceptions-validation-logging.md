# Lesson 14: Exceptions, Validation Basics, and Logging Intro

Bu sənəd dərsdə izah üçün hazırlanıb: konsept + real-world nümunə + praktik kod.

## 1) Exceptions nədir və niyə vacibdir?

Exception proqram axınında gözlənilməz və ya qayda pozuntusu halıdır.  
Məqsəd: proqramı “səssiz” səhvlərlə davam etdirmək yox, problemi idarə olunan şəkildə göstərməkdir.

Real-world:
- Bank köçürməsində məbləğ mənfidirsə -> validation xətası
- Fayl tapılmırsa -> IO xətası
- DB əlaqəsi qopursa -> runtime xətası

---

## 2) Checked vs Unchecked Exceptions

## Checked Exception

- Compile time-da məcburi handle olunur (`try/catch` və ya `throws`).
- Adətən recover edilə bilən xarici resurs xətalarıdır.
- Məsələn: `IOException`, `SQLException`.

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExample {
    public static String readFirstLine(String file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.readLine();
        }
    }
}
```

## Unchecked Exception

- Compile time məcbur etmir.
- `RuntimeException` və törəmələridir.
- Adətən proqramlama/validation xətalarıdır: `NullPointerException`, `IllegalArgumentException`.

```java
public class UncheckedExample {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("b 0 ola bilmez");
        }
        return a / b;
    }
}
```

Qısa qayda:
- Xarici sistem/fayl/network -> çox vaxt checked
- Domain qayda pozuntusu/yanlış input -> çox vaxt unchecked (custom runtime)

---

## 3) try / catch / finally

## `try`
Riskli kod bloku.

## `catch`
Xətanı qarşılayıb idarə edir.

## `finally`
Hər halda işləyir (resource cleanup üçün).

```java
public class TryCatchFinallyDemo {
    public static void main(String[] args) {
        String raw = "42a";
        try {
            int value = Integer.parseInt(raw);
            System.out.println("Parsed: " + value);
        } catch (NumberFormatException e) {
            System.out.println("Input reqem deyil: " + raw);
        } finally {
            System.out.println("Audit: parse attempt bitdi");
        }
    }
}
```

Qeyd: Fayl/DB kimi resource-larda `try-with-resources` daha doğrudur.

---

## 4) `throw` vs `throws`

- `throw`: konkret exception obyektini atır.
- `throws`: metod imzasında “bu xətanı ötürə bilərəm” deyir.

```java
import java.io.IOException;

public class ThrowVsThrows {
    public static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Yas menfi ola bilmez");
        }
    }

    public static void readConfig() throws IOException {
        throw new IOException("config fayli tapilmadi");
    }
}
```

---

## 5) Custom Exception dizaynı

Domain problemi üçün öz exception class-larını yaratmaq kodu daha oxunaqlı edir.

Nümunə: e-commerce checkout

```java
public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}
```

```java
public class ProductService {
    public void reserve(String sku, int requestedQty, int stockQty) {
        if (requestedQty <= 0) {
            throw new IllegalArgumentException("requestedQty musbet olmalidir");
        }
        if (requestedQty > stockQty) {
            throw new InsufficientStockException(
                    "Stok catmir. SKU=" + sku + ", requested=" + requestedQty + ", stock=" + stockQty);
        }
        System.out.println("Reserved: " + requestedQty);
    }
}
```

Niyə yaxşıdır?
- Controller/service layer problemi dəqiq anlayır
- User-a düzgün mesaj qaytarmaq asan olur
- Log-larda root cause daha aydın görünür

---

## 6) Defensive Programming mindset

Məntiq: “input həmişə ideal gəlməyəcək”.

Minimum defensiv qaydalar:
1. Public metod girişlərini yoxla (`null`, range, format).
2. Yanlış state-i erkən dayandır (`fail early`).
3. Xəta mesajı kontekstli olsun (ID, əməliyyat tipi).
4. Heç vaxt exception-u “udma” (`catch` edib susma).

Praktik nümunə:

```java
import java.util.Objects;

public class TransferService {
    public void transfer(String fromIban, String toIban, double amount) {
        Objects.requireNonNull(fromIban, "fromIban null ola bilmez");
        Objects.requireNonNull(toIban, "toIban null ola bilmez");

        if (fromIban.isBlank() || toIban.isBlank()) {
            throw new IllegalArgumentException("IBAN bos ola bilmez");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Mebleg musbet olmalidir");
        }
        if (fromIban.equals(toIban)) {
            throw new IllegalArgumentException("Eyni hesaba kocurme olmaz");
        }

        System.out.println("Transfer ugurlu: " + amount);
    }
}
```

---

## 7) Structured Logging intro (prinsiplər)

`System.out.println` dərs üçün yaxşıdır, prod üçün yetərli deyil.  
Logging-də məqsəd: axtarıla bilən, filtrlənə bilən, kontekstli qeydlər.

Prinsiplər:
1. Log level istifadə et: `INFO`, `WARN`, `ERROR`, `DEBUG`.
2. Mesajda kontekst olsun: `orderId`, `userId`, `operation`.
3. Xətada stacktrace-i saxla.
4. Sensitive data loglama (şifrə, kart nömrəsi, token) etmə.

SLF4J nümunəsi:

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentService {
    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    public void pay(String orderId, double amount) {
        log.info("Payment started orderId={} amount={}", orderId, amount);
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("amount must be > 0");
            }
            // external gateway call...
            log.info("Payment success orderId={}", orderId);
        } catch (Exception e) {
            log.error("Payment failed orderId={} reason={}", orderId, e.getMessage(), e);
            throw e;
        }
    }
}
```

Bu formatın üstünlüyü:
- Kibana/Grafana/Splunk-da axtarış rahat olur
- Incident araşdırması sürətlənir

---

## 8) End-to-end mini real flow (Validation + Exception + Logging)

Scenario: `OrderController -> OrderService -> InventoryService`

```java
public record CreateOrderRequest(String userId, String sku, int qty) {}
```

```java
public class ValidationException extends RuntimeException {
    public ValidationException(String message) { super(message); }
}
```

```java
public class InventoryException extends RuntimeException {
    public InventoryException(String message) { super(message); }
}
```

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public String create(CreateOrderRequest req, int stockQty) {
        if (req == null) throw new ValidationException("request null ola bilmez");
        if (req.userId() == null || req.userId().isBlank()) throw new ValidationException("userId bosdur");
        if (req.sku() == null || req.sku().isBlank()) throw new ValidationException("sku bosdur");
        if (req.qty() <= 0) throw new ValidationException("qty musbet olmalidir");

        log.info("Create order attempt userId={} sku={} qty={}", req.userId(), req.sku(), req.qty());

        if (req.qty() > stockQty) {
            throw new InventoryException("stok catmir sku=" + req.sku());
        }

        String orderId = "ORD-" + System.currentTimeMillis();
        log.info("Order created orderId={} userId={}", orderId, req.userId());
        return orderId;
    }
}
```

Controller səviyyəsində yanaşma:
- `ValidationException` -> 400 Bad Request
- `InventoryException` -> 409 Conflict
- digər gözlənilməz exception -> 500

Bu mapping tələbələrə “exception handling only backend daxilində deyil, API contract-ın bir hissəsidir” fikrini öyrədir.

---

## 9) Tələbələrin çox etdiyi səhvlər

1. `catch (Exception e) {}` boş buraxmaq.
2. Hər yeri `try/catch`-ə bürümək (səhv layer-də handle etmək).
3. `printStackTrace()` ilə kifayətlənmək.
4. Exception mesajında kontekst verməmək.
5. Custom exception hierarchy qurmayıb hər şeyi `RuntimeException` etmək.

---

## 10) Dərs üçün mini practice tasks

1. `PaymentValidationException` yarat, amount/card yoxlaması yaz.
2. Fayldan config oxuyan metod yaz (`throws IOException`).
3. `try-with-resources` ilə CSV oxu.
4. `OrderService`-də validation + custom exception + logging əlavə et.
5. 3 fərqli exception üçün API status mapping cədvəli hazırla.

---

## 11) Yekun xülasə

- Exception handling məqsədi: sistemin etibarlı və idarə olunan davranmasıdır.
- Defensive programming səhvləri erkən tutur.
- Custom exception domain dili yaradır.
- Structured logging production debugging üçün vacibdir.
