package l10.task.policy;

import java.math.BigDecimal;

import l10.task.model.Order;

public interface PricingPolicy {
    BigDecimal calculateTotal(Order order);

    String getPolicyName();
}
