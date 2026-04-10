package l10.abstraction.polymorphism.interfaces.part1;

import java.math.BigDecimal;

public class Test3 {

    public static void main(String[] args) {
        Payment cardPayment = new CardPayment();
        Payment cashPayment = new CashPayment();

        Payment[] payments = {cardPayment, cashPayment};

        for (Payment payment : payments) {
            payment.pay(BigDecimal.TEN);

            if (payment instanceof CardPayment cp) {
                cp.reverse();
            }
        }

    }

}
