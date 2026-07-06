package lesson24;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        String bakuTime = Instant.now()
                .atZone(ZoneId.of("Asia/Baku"))
                .format(formatter);

        System.out.println(bakuTime);
    }
}
