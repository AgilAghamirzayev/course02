package l10.task.policy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import l10.task.model.Order;

public final class PercentageDiscountPricingPolicy implements PricingPolicy {
    private final int discountPercent;
    private final BigDecimal multiplier;

    public PercentageDiscountPricingPolicy(int discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("discountPercent must be between 0 and 100");
        }
        this.discountPercent = discountPercent;
        this.multiplier = BigDecimal.ONE.subtract(BigDecimal.valueOf(discountPercent).movePointLeft(2));
    }

    @Override
    public BigDecimal calculateTotal(Order order) {
        Objects.requireNonNull(order, "order must not be null");
        return order.baseTotal()
                .multiply(multiplier)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String getPolicyName() {
        return "Percentage Discount Pricing (" + discountPercent + "%)";
    }
}
