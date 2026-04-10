package l10.abstraction.polymorphism.interfaces.part1;

import java.math.BigDecimal;

public class Test4 {

    public static void main(String[] args) {
        CardPayment cardPayment = new CardPayment();

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
