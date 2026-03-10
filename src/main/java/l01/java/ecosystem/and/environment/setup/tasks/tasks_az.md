# Dərs 1 Ev Tapşırığı - Java Mühitinin Qurulması və İlk Kompilyasiya

## Məqsəd

Bu tapşırığın məqsədi Java inkişaf mühitinin necə işlədiyini və Java kodunun necə kompilyasiya olunub icra edildiyini anlamağa kömək etməkdir.

Bu tapşırığı tamamladıqda siz Java alətlərinin quraşdırılmasını, JDK strukturunun araşdırılmasını və Java proqramlarının əl ilə kompilyasiya olunmasını öyrənəcəksiniz.

## Tapşırıq 1 - Java İnkişaf Alətlərini Quraşdırın

### Təlimatlar

1. Java Development Kit-i (JDK) yükləyin və quraşdırın.
2. IntelliJ IDEA Community Edition-u yükləyin və quraşdırın.
3. Java-nın düzgün quraşdırıldığını yoxlayın.

### Yoxlama

Terminalı açın (Command Prompt / Terminal) və aşağıdakı əmrləri icra edin:

```bash
java -version
javac -version
```

### Gözlənilən Nəticə

Terminalda quraşdırılmış Java versiyası göstərilməlidir.

### Təhvil

Terminal çıxışında quraşdırılmış Java versiyasını göstərən ekran görüntüsünü yükləyin.

## Tapşırıq 2 - JDK Strukturunu Araşdırın

### Təlimatlar

1. Kompüterinizdə JDK quraşdırma qovluğunu tapın.
2. `bin` qovluğuna keçin.
3. Aşağıdakı vacib faylları tapın:
   - `javac` -> Java kompilyatoru
   - `java` -> JVM işə salıcısı
4. Aşağıdakıları anlayın:
   - `javac`, `.java` fayllarını `.class` baytkoduna çevirir.
   - `java`, baytkodu JVM vasitəsilə icra edir.

### Təhvil

JDK-nın `bin` qovluğunda `javac` və `java` fayllarını göstərən ekran görüntüsünü çəkib sinif otağına yükləyin.

## Tapşırıq 3 - Java Proqramını Əl ilə Kompilyasiya Edin

### Təlimatlar

1. Sadə bir Java proqramı yaradın.

Nümunə:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Java World!");
    }
}
```

2. Faylı bu adla yadda saxlayın:

```text
HelloWorld.java
```

### Proqramın Kompilyasiyası

Terminalı açın və aşağıdakı əmri icra edin:

```bash
javac HelloWorld.java
```

### Gözlənilən Nəticə

Yeni fayl yaranmalıdır:

```text
HelloWorld.class
```

### Proqramı İşə Salın

Proqramı aşağıdakı əmrlə icra edin:

```bash
java HelloWorld
```

### Gözlənilən Çıxış

```text
Hello, Java World!
```

### Təhvil Materialları

Yükləyin:

1. Kompilyasiya əmri (`javac`) göstərilən terminal ekran görüntüsü
2. Yaradılmış `.class` faylını göstərən ekran görüntüsü
3. Proqram çıxışını göstərən ekran görüntüsü
