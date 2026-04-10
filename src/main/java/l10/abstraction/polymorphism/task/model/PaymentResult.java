package l10.abstraction.polymorphism.task.model;

import java.util.Objects;

public final class PaymentResult {
    private final boolean success;
    private final String transactionId;
    private final String message;

    public PaymentResult(boolean success, String transactionId, String message) {
        this.success = success;
        this.transactionId = Objects.requireNonNull(transactionId, "transactionId must not be null");
        this.message = Objects.requireNonNull(message, "message must not be null");
    }

    public boolean isSuccess() {
        return success;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getMessage() {
        return message;
    }
}
