package l10.abstraction.polymorphism.task.printer;

import java.util.Objects;

import l10.abstraction.polymorphism.task.model.OrderReceipt;

public final class ConsoleOrderPrinter implements OrderPrinter {
    @Override
    public void print(OrderReceipt receipt) {
        Objects.requireNonNull(receipt, "receipt must not be null");

        System.out.printf("Order ID       : %s%n", receipt.getOrderId());
        System.out.printf("Product        : %s%n", receipt.getProductName());
        System.out.printf("Quantity       : %d%n", receipt.getQuantity());
        System.out.printf("Unit Price     : %s%n", receipt.getUnitPrice());
        System.out.printf("Pricing Policy : %s%n", receipt.getPricingPolicyName());
        System.out.printf("Final Total    : %s%n", receipt.getFinalTotal());
        System.out.printf("Payment Status : %s%n", receipt.isPaymentSuccess() ? "SUCCESS" : "FAILED");
        System.out.printf("Transaction ID : %s%n", receipt.getTransactionId());
        System.out.printf("Message        : %s%n", receipt.getPaymentMessage());
    }
}
