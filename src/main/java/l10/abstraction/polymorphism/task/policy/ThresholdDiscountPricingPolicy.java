package l10.abstraction.polymorphism.task.policy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import l10.abstraction.polymorphism.task.model.Order;

public final class ThresholdDiscountPricingPolicy implements PricingPolicy {
    private final BigDecimal threshold;
    private final BigDecimal fixedDiscount;

    public ThresholdDiscountPricingPolicy(BigDecimal threshold, BigDecimal fixedDiscount) {
        Objects.requireNonNull(threshold, "threshold must not be null");
        Objects.requireNonNull(fixedDiscount, "fixedDiscount must not be null");

        if (threshold.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("threshold cannot be negative");
        }
        if (fixedDiscount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("fixedDiscount cannot be negative");
        }

        this.threshold = threshold.setScale(2, RoundingMode.HALF_UP);
        this.fixedDiscount = fixedDiscount.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calculateTotal(Order order) {
        Objects.requireNonNull(order, "order must not be null");

        BigDecimal baseTotal = order.baseTotal();
        if (baseTotal.compareTo(threshold) >= 0) {
            return baseTotal
                    .subtract(fixedDiscount)
                    .max(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        return baseTotal;
    }

    @Override
    public String getPolicyName() {
        return "Threshold Discount Pricing (discount " + fixedDiscount + " over " + threshold + ")";
    }
}
