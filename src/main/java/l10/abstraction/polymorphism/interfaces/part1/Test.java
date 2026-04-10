package l10.abstraction.polymorphism.interfaces.part1;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        CardPayment cardPayment = new CardPayment();
        processPayment(cardPayment);

        System.out.println();

        CashPayment cashPayment = new CashPayment();
        processPayment(cashPayment);
    }

    public static void processPayment(Payment cardPayment) {
        cardPayment.pay(BigDecimal.TEN);
    }

}
