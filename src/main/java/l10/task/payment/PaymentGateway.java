package l10.task.payment;

import java.math.BigDecimal;

import l10.task.model.PaymentResult;

public interface PaymentGateway {
    PaymentResult pay(String orderId, BigDecimal amount);
}
