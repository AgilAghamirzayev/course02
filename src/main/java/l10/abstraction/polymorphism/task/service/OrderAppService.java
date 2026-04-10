package l10.abstraction.polymorphism.task.service;

import java.math.BigDecimal;
import java.util.Objects;

import l10.abstraction.polymorphism.task.model.Order;
import l10.abstraction.polymorphism.task.model.OrderReceipt;
import l10.abstraction.polymorphism.task.model.PaymentResult;
import l10.abstraction.polymorphism.task.payment.PaymentGateway;
import l10.abstraction.polymorphism.task.policy.PricingPolicy;
import l10.abstraction.polymorphism.task.printer.OrderPrinter;

public final class OrderAppService {
    private final PricingPolicy pricingPolicy;
    private final PaymentGateway paymentGateway;
    private final OrderPrinter orderPrinter;

    public OrderAppService(
            PricingPolicy pricingPolicy,
            PaymentGateway paymentGateway,
            OrderPrinter orderPrinter
    ) {
        this.pricingPolicy = Objects.requireNonNull(pricingPolicy, "pricingPolicy must not be null");
        this.paymentGateway = Objects.requireNonNull(paymentGateway, "paymentGateway must not be null");
        this.orderPrinter = Objects.requireNonNull(orderPrinter, "orderPrinter must not be null");
    }

    public OrderReceipt processOrder(Order order) {
        Objects.requireNonNull(order, "order must not be null");

        BigDecimal total = pricingPolicy.calculateTotal(order);
        PaymentResult paymentResult = paymentGateway.pay(order.getOrderId(), total);

        OrderReceipt receipt = new OrderReceipt(
                order.getOrderId(),
                order.getProductName(),
                order.getQuantity(),
                order.getUnitPrice(),
                pricingPolicy.getPolicyName(),
                total,
                paymentResult.isSuccess(),
                paymentResult.getTransactionId(),
                paymentResult.getMessage()
        );

        orderPrinter.print(receipt);
        return receipt;
    }
}
