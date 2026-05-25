package lesson22.threads;

import static java.time.ZoneOffset.UTC;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().atZone(UTC));
        System.out.println(LocalDateTime.now());
    }
}
