package l10.abstraction.polymorphism.task.policy;

import java.math.BigDecimal;
import java.util.Objects;

import l10.abstraction.polymorphism.task.model.Order;

public final class StandardPricingPolicy implements PricingPolicy {
    @Override
    public BigDecimal calculateTotal(Order order) {
        Objects.requireNonNull(order, "order must not be null");
        return order.baseTotal();
    }

    @Override
    public String getPolicyName() {
        return "Standard Pricing";
    }
}
