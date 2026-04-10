package l10.abstraction.polymorphism.interfaces.part1;

import java.math.BigDecimal;

public class CashPayment implements Payment {

    @Override
    public void pay(BigDecimal amount) {
        System.out.println(MESSAGE_FORMAT.formatted(START, "Cash payment") + amount);
        System.out.println("Processing payment...");
        System.out.println(MESSAGE_FORMAT.formatted(END, "Cash payment") + amount);
    }

}
