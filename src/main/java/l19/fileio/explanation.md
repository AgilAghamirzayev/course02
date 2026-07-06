# Lesson 19: Java I/O and NIO.2

This lesson teaches how Java reads and writes data correctly, efficiently, and safely.
You will move from basic stream concepts to production-style NIO.2 file utilities.

## In-class coverage

- [ ] Byte streams vs character streams
- [ ] Encoding/charset fundamentals and data correctness
- [ ] Buffering and performance considerations
- [ ] NIO.2 APIs: `Path`, `Files`, directory operations
- [ ] Safe file handling in backend utilities

## Learning Objectives

By the end of this lesson, students should be able to:

- Explain the difference between binary and text I/O in Java
- Choose correct APIs (`InputStream`/`OutputStream` vs `Reader`/`Writer`)
- Prevent text corruption by using explicit charsets (usually UTF-8)
- Use buffering to improve I/O performance
- Work with NIO.2 (`Path`, `Files`) for file and directory operations
- Implement safe backend file utilities (validation, atomic writes, cleanup)

## 1. Java I/O Mental Model

I/O means moving data between your program and external resources:

- files
- network sockets
- process pipes
- in-memory byte buffers

Java has two main I/O families:

1. classic stream APIs (`java.io`)
2. NIO.2 file APIs (`java.nio.file`) for modern filesystem work

Both are used in real systems. NIO.2 is usually preferred for file path and file operation logic.

## 2. Byte Streams vs Character Streams

### 2.1 Byte streams (`InputStream`, `OutputStream`)

Use for raw binary data:

- images
- PDFs
- ZIP files
- encrypted payloads

Core types:

- `FileInputStream`, `FileOutputStream`
- `BufferedInputStream`, `BufferedOutputStream`

Example: copy a binary file safely:

```java
import java.io.*;

public class BinaryCopyDemo {
    public static void copyFile(File src, File dst) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(src));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(dst))) {
            byte[] buffer = new byte[8192];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        }
    }
}
```

### 2.2 Character streams (`Reader`, `Writer`)

Use for text data:

- JSON
- CSV
- logs
- configuration files

Core types:

- `FileReader`, `FileWriter` (avoid without charset)
- `BufferedReader`, `BufferedWriter`
- `InputStreamReader`, `OutputStreamWriter`

Example: read text line by line:

```java
import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextReadDemo {
    public static void printLines(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
```

### 2.3 Quick decision rule

- Data is binary -> byte streams
- Data is human-readable text -> character streams

Never use `Reader`/`Writer` for binary files. It corrupts data.

## 3. Encoding and Charset Fundamentals

### 3.1 Why encoding matters

Text in memory is Unicode (`char`/`String` model). Files store bytes.
Charset defines how bytes map to characters.

If write-charset != read-charset, text can break (garbled output).

### 3.2 Always specify charset explicitly

Do not rely on platform default charset.

Good:

```java
Files.writeString(path, "Cafe", StandardCharsets.UTF_8);
String text = Files.readString(path, StandardCharsets.UTF_8);
```

Risky:

```java
new FileWriter("data.txt");  // platform default charset
new FileReader("data.txt");  // platform default charset
```

### 3.3 Common charsets

- `UTF-8` (default standard for modern backend systems)
- `ISO_8859_1` (legacy systems)
- `UTF-16` (some platform/export use cases)

### 3.4 Data correctness checklist

- Use one charset end-to-end (usually UTF-8)
- Document charset in file contracts and APIs
- Validate decoding errors for external/untrusted files
- Add tests with non-ASCII text

## 4. Buffering and Performance Considerations

### 4.1 Why buffering is important

Disk and network I/O are expensive operations. Reading/writing one byte at a time causes many system calls.
Buffering reduces calls by batching data.

### 4.2 Buffered wrappers

- `BufferedInputStream`, `BufferedOutputStream`
- `BufferedReader`, `BufferedWriter`

### 4.3 Typical buffer size

`8192` bytes is a common default and good starting point.
Benchmark only if your workload is large or latency-sensitive.

### 4.4 `flush()` and data visibility

- `close()` flushes automatically
- Use `flush()` when you need data visible before closing
- Avoid flushing after every small write in high-throughput code

### 4.5 Prefer high-level NIO.2 helpers where possible

`Files.copy`, `Files.readAllLines`, `Files.newBufferedReader`, `Files.newBufferedWriter` are concise and usually optimized.

## 5. NIO.2: `Path`, `Files`, Directory Operations

### 5.1 `Path` over `File`

`Path` is modern, composable, and cross-platform friendly.

```java
Path base = Path.of("data");
Path report = base.resolve("reports").resolve("daily.csv");
```

### 5.2 Basic file operations with `Files`

```java
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class FilesDemo {
    public static void run() throws IOException {
        Path dir = Path.of("data");
        Files.createDirectories(dir);

        Path file = dir.resolve("notes.txt");
        Files.writeString(file, "line1\nline2\n", StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        String all = Files.readString(file, StandardCharsets.UTF_8);
        List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);

        Path backup = dir.resolve("notes.bak.txt");
        Files.copy(file, backup, StandardCopyOption.REPLACE_EXISTING);

        Path moved = dir.resolve("archive").resolve("notes.txt");
        Files.createDirectories(moved.getParent());
        Files.move(file, moved, StandardCopyOption.REPLACE_EXISTING);
    }
}
```

### 5.3 Directory listing patterns

Small directory:

```java
try (DirectoryStream<Path> stream = Files.newDirectoryStream(Path.of("data"))) {
    for (Path p : stream) {
        System.out.println(p.getFileName());
    }
}
```

Recursive traversal:

```java
try (var walk = Files.walk(Path.of("data"))) {
    walk.filter(Files::isRegularFile)
        .forEach(System.out::println);
}
```

### 5.4 Useful existence and metadata checks

- `Files.exists(path)`
- `Files.isDirectory(path)`
- `Files.isRegularFile(path)`
- `Files.size(path)`
- `Files.getLastModifiedTime(path)`

## 6. Safe File Handling in Backend Utilities

Backend file code must protect against security, corruption, and concurrency issues.

### 6.1 Path traversal protection

If userEntity input is part of a file path, resolve and normalize against a fixed base directory.

```java
import java.nio.file.Path;

public class SafePathResolver {
    private final Path baseDir;

    public SafePathResolver(Path baseDir) {
        this.baseDir = baseDir.toAbsolutePath().normalize();
    }

    public Path resolveUserFile(String userFileName) {
        Path candidate = baseDir.resolve(userFileName).normalize();
        if (!candidate.startsWith(baseDir)) {
            throw new IllegalArgumentException("Invalid file path");
        }
        return candidate;
    }
}
```

### 6.2 Atomic write pattern

Write to temp file first, then atomically move to target.
This prevents partial/corrupted target files.

```java
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class AtomicWriteUtil {
    public static void writeUtf8Atomic(Path target, String content) throws IOException {
        Files.createDirectories(target.getParent());
        Path temp = Files.createTempFile(target.getParent(), "tmp-", ".part");
        try {
            Files.writeString(temp, content, StandardCharsets.UTF_8,
                    StandardOpenOption.TRUNCATE_EXISTING);
            Files.move(temp, target,
                    StandardCopyOption.ATOMIC_MOVE,
                    StandardCopyOption.REPLACE_EXISTING);
        } finally {
            Files.deleteIfExists(temp);
        }
    }
}
```

### 6.3 Safer create semantics

Use `CREATE_NEW` when file must not already exist:

```java
Files.writeString(path, payload, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
```

This prevents accidental overwrite races.

### 6.4 Validate inputs and limits

- Reject invalid filenames early
- Enforce max upload size
- Stream large files (avoid loading everything into memory)
- Restrict writable directories by configuration

### 6.5 Error handling and observability

- Use try-with-resources for automatic close
- Wrap low-level `IOException` into domain errors where appropriate
- Log path + operation + error message (without leaking sensitive data)

## 7. Common Mistakes Checklist

- Using platform-default charset unintentionally
- Reading binary files through `Reader`
- Forgetting buffering in hot I/O paths
- Building paths via string concatenation instead of `Path.resolve(...)`
- Doing `exists()` then `create` in separate unsafe steps
- Writing directly to target file without atomic replacement
- Missing `try-with-resources` and leaking file handles

## 8. In-class Mini Practice Tasks

1. Implement a text file reader that counts lines, words, and characters using UTF-8.
2. Copy an image file using byte streams and verify equal file sizes.
3. Benchmark unbuffered vs buffered copy for a large file.
4. Create a utility that writes a CSV report using `Files.newBufferedWriter`.
5. Build a directory scanner that lists only `.log` files recursively.
6. Implement safe userEntity path resolution and reject traversal attempts.
7. Implement atomic config file update with temp file + move.
8. Refactor one old `File`-based utility to `Path` + `Files`.

## 9. Summary

Reliable backend file handling requires three decisions every time:

1. Correct data model: bytes vs characters
2. Correct encoding: explicit UTF-8 unless contract says otherwise
3. Correct operational safety: buffering, NIO.2 APIs, atomic and validated file operations

When these are applied consistently, file utilities stay correct, fast, and production-safe.
