package l10.abstraction.polymorphism.task;

import java.math.BigDecimal;

import l10.abstraction.polymorphism.task.model.Order;
import l10.abstraction.polymorphism.task.payment.MockPaymentGateway;
import l10.abstraction.polymorphism.task.payment.PaymentGateway;
import l10.abstraction.polymorphism.task.policy.PercentageDiscountPricingPolicy;
import l10.abstraction.polymorphism.task.policy.PricingPolicy;
import l10.abstraction.polymorphism.task.policy.StandardPricingPolicy;
import l10.abstraction.polymorphism.task.policy.ThresholdDiscountPricingPolicy;
import l10.abstraction.polymorphism.task.printer.ConsoleOrderPrinter;
import l10.abstraction.polymorphism.task.printer.OrderPrinter;
import l10.abstraction.polymorphism.task.service.OrderAppService;

public class Task12HardInterfaceDrivenMiniApp {

    public static void main(String[] args) {
        PaymentGateway paymentGateway = new MockPaymentGateway();
        OrderPrinter orderPrinter = new ConsoleOrderPrinter();

        runScenario(
                "ORDER SCENARIO 1 - STANDARD PRICING",
                new StandardPricingPolicy(),
                paymentGateway,
                orderPrinter,
                new Order("ORD-1001", "Laptop", 1, new BigDecimal("1500.00"))
        );

        runScenario(
                "ORDER SCENARIO 2 - PERCENTAGE DISCOUNT",
                new PercentageDiscountPricingPolicy(15),
                paymentGateway,
                orderPrinter,
                new Order("ORD-1002", "Headphones", 2, new BigDecimal("120.00"))
        );

        runScenario(
                "ORDER SCENARIO 3 - THRESHOLD DISCOUNT",
                new ThresholdDiscountPricingPolicy(new BigDecimal("1000.00"), new BigDecimal("120.00")),
                paymentGateway,
                orderPrinter,
                new Order("ORD-1003", "Office Chair", 2, new BigDecimal("600.00"))
        );
    }

    private static void runScenario(
            String title,
            PricingPolicy pricingPolicy,
            PaymentGateway paymentGateway,
            OrderPrinter orderPrinter,
            Order order
    ) {
        System.out.println("\n========== " + title + " ==========");
        OrderAppService service = new OrderAppService(pricingPolicy, paymentGateway, orderPrinter);
        service.processOrder(order);
    }
}
