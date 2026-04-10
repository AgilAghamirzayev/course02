package l10.abstraction.polymorphism.task.payment;

import java.math.BigDecimal;

import l10.abstraction.polymorphism.task.model.PaymentResult;

public interface PaymentGateway {
    PaymentResult pay(String orderId, BigDecimal amount);
}
