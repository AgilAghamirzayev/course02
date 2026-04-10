package l10.abstraction.polymorphism.task.policy;

import java.math.BigDecimal;

import l10.abstraction.polymorphism.task.model.Order;

public interface PricingPolicy {
    BigDecimal calculateTotal(Order order);

    String getPolicyName();
}
