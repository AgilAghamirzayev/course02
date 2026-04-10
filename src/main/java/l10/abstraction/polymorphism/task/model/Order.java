package l10.abstraction.polymorphism.task.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Order {
    private final String orderId;
    private final String productName;
    private final int quantity;
    private final BigDecimal unitPrice;

    public Order(String orderId, String productName, int quantity, BigDecimal unitPrice) {
        this.orderId = requireText(orderId, "orderId");
        this.productName = requireText(productName, "productName");
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be greater than zero");
        }
        Objects.requireNonNull(unitPrice, "unitPrice must not be null");
        if (unitPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("unitPrice cannot be negative");
        }
        this.quantity = quantity;
        this.unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP);
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

    public BigDecimal baseTotal() {
        return unitPrice
                .multiply(BigDecimal.valueOf(quantity))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
        return value.trim();
    }
}
