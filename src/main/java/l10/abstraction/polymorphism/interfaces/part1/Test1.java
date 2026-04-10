package l10.abstraction.polymorphism.interfaces.part1;

import java.math.BigDecimal;

public class Test1 {
    public static void main(String[] args) {
        Payment cardPayment = new CardPayment();
        cardPayment.pay(BigDecimal.TEN);

        System.out.println();

        Payment cashPayment = new CashPayment();
        cashPayment.pay(BigDecimal.TEN);
    }

    public static void processPayment(Payment cardPayment) {
        cardPayment.pay(BigDecimal.TEN);
    }

}
