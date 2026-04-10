package l10.abstraction.polymorphism.task.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class OrderReceipt {
    private final String orderId;
    private final String productName;
    private final int quantity;
    private final BigDecimal unitPrice;
    private final String pricingPolicyName;
    private final BigDecimal finalTotal;
    private final boolean paymentSuccess;
    private final String transactionId;
    private final String paymentMessage;

    public OrderReceipt(
            String orderId,
            String productName,
            int quantity,
            BigDecimal unitPrice,
            String pricingPolicyName,
            BigDecimal finalTotal,
            boolean paymentSuccess,
            String transactionId,
            String paymentMessage
    ) {
        this.orderId = Objects.requireNonNull(orderId, "orderId must not be null");
        this.productName = Objects.requireNonNull(productName, "productName must not be null");
        this.quantity = quantity;
        this.unitPrice = Objects.requireNonNull(unitPrice, "unitPrice must not be null")
                .setScale(2, RoundingMode.HALF_UP);
        this.pricingPolicyName = Objects.requireNonNull(pricingPolicyName, "pricingPolicyName must not be null");
        this.finalTotal = Objects.requireNonNull(finalTotal, "finalTotal must not be null")
                .setScale(2, RoundingMode.HALF_UP);
        this.paymentSuccess = paymentSuccess;
        this.transactionId = Objects.requireNonNull(transactionId, "transactionId must not be null");
        this.paymentMessage = Objects.requireNonNull(paymentMessage, "paymentMessage must not be null");
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getPricingPolicyName() {
        return pricingPolicyName;
    }

    public BigDecimal getFinalTotal() {
        return finalTotal;
    }

    public boolean isPaymentSuccess() {
        return paymentSuccess;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPaymentMessage() {
        return paymentMessage;
    }
}
