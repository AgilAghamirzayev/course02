package l10.abstraction.polymorphism.interfaces.part1;

import java.math.BigDecimal;

public class CardPayment implements Payment {

    @Override
    public void pay(BigDecimal amount) {
        System.out.println(MESSAGE_FORMAT.formatted(START, "Card payment") + amount);
        System.out.println("Processing payment...");
        System.out.println(MESSAGE_FORMAT.formatted(END, "Card payment") + amount);
    }

    public void reverse() {
        System.out.println("Reversing payment...");
    }

}
