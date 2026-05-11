package l18.streams.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LogProcessingCaseStudy {
    private static final Path LOG_PATH = Paths.get("src/main/java/l18/streams/practice/application-logs.txt");

    public static void main(String[] args) throws IOException {
        List<LogEntry> logs = loadLogs(LOG_PATH);

        Map<Integer, Map.Entry<String, Long>> hourlyTopErrors = logs.stream()
                .filter(log -> log.level() == Level.ERROR)
                .collect(Collectors.groupingBy(
                        log -> log.timestamp().getHour(),
                        Collectors.groupingBy(
                                LogEntry::message,
                                Collectors.counting()
                        )
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().entrySet().stream()
                                .max(Map.Entry.comparingByValue())
                                .orElseThrow()
                ));


        System.out.println("-----------");
        hourlyTopErrors.entrySet().stream()
                .sorted(
                        Comparator.<Map.Entry<Integer, Map.Entry<String, Long>>>comparingLong(
                                        entry -> entry.getValue().getValue()
                                )
                                .reversed()
                                .thenComparing(Map.Entry::getKey)
                )
                .forEach(entry -> {
                    int hour = entry.getKey();
                    String message = entry.getValue().getKey();
                    long count = entry.getValue().getValue();
                    System.out.printf("%02d:00-%02d:59: %s (%d occurrences)%n",
                            hour, hour, message, count);
                });
    }

    private static List<LogEntry> loadLogs(Path logPath) throws IOException {
        List<String> lines = Files.readAllLines(logPath);

        return IntStream.range(0, lines.size())
                .mapToObj(index -> parseLine(lines.get(index), index + 1))
                .filter(Objects::nonNull)
                .toList();
    }

    private static LogEntry parseLine(String rawLine, int lineNumber) {
        String line = rawLine.trim();
        if (line.isEmpty() || line.startsWith("#")) {
            return null;
        }

        String[] parts = line.split("\\|", 3);
        if (parts.length != 3) {
            throw new IllegalArgumentException(
                    "Invalid log format at line " + lineNumber + ": " + rawLine
            );
        }

        LocalDateTime timestamp = LocalDateTime.parse(parts[0].trim());
        Level level = Level.valueOf(parts[1].trim().toUpperCase(Locale.ROOT));
        String message = parts[2].trim();

        return new LogEntry(timestamp, level, message);
    }

    private enum Level {
        INFO,
        WARNING,
        ERROR
    }

    private record LogEntry(LocalDateTime timestamp, Level level, String message) {
    }

}
