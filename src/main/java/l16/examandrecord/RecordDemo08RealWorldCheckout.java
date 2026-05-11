package l16.examandrecord;

import java.math.BigDecimal;
import java.time.Instant;

public class RecordDemo08RealWorldCheckout {

    public record CheckoutResponse(
            String orderId,
            BigDecimal total,
            String currency,
            String status,
            Instant createdAt
    ) {
        public CheckoutResponse {
            if (orderId == null || orderId.isBlank()) {
                throw new IllegalArgumentException("orderId bos ola bilmez");
            }
            if (total == null || total.signum() < 0) {
                throw new IllegalArgumentException("mebleg menfi ola bilmez");
            }
            if (currency == null || currency.isBlank()) {
                throw new IllegalArgumentException("currency bos ola bilmez");
            }
            if (status == null || status.isBlank()) {
                throw new IllegalArgumentException("status bos ola bilmez");
            }
        }
    }

    public static void main(String[] args) {
        CheckoutResponse ok = new CheckoutResponse(
                "ORD-2026-0001",
                new BigDecimal("149.90"),
                "AZN",
                "PAID",
                Instant.now()
        );
        System.out.println("Checkout response: " + ok);

        try {
            new CheckoutResponse("", new BigDecimal("-1"), "AZN", "PAID", Instant.now());
        } catch (IllegalArgumentException e) {
            System.out.println("Validation xetasi: " + e.getMessage());
        }
    }
}

