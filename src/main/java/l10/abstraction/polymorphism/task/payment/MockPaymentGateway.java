package l10.abstraction.polymorphism.task.payment;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import l10.abstraction.polymorphism.task.model.PaymentResult;

public final class MockPaymentGateway implements PaymentGateway {
    private static final AtomicLong TRANSACTION_SEQUENCE = new AtomicLong(1000);

    @Override
    public PaymentResult pay(String orderId, BigDecimal amount) {
        Objects.requireNonNull(orderId, "orderId must not be null");
        Objects.requireNonNull(amount, "amount must not be null");

        boolean success = amount.compareTo(BigDecimal.ZERO) > 0;
        String transactionId = "TXN-" + TRANSACTION_SEQUENCE.incrementAndGet();
        String message = success
                ? "Payment approved"
                : "Payment failed: amount must be positive";

        return new PaymentResult(success, transactionId, message);
    }
}
