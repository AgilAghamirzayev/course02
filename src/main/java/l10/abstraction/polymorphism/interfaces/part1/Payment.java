package l10.abstraction.polymorphism.interfaces.part1;

import java.math.BigDecimal;

public interface Payment {

    String START = "START";
    String END = "END";
    String MESSAGE_FORMAT = "%s -> %s : ";

    public abstract void pay(BigDecimal amount);

    default void print(String message) {
        print(message, START);
    }

    private void print(String message, String type) {
        System.out.println(MESSAGE_FORMAT.formatted(type, message));
    }

    private void printa(String message, String type) {
        System.out.println(MESSAGE_FORMAT.formatted(type, message));
    }

    static void main() {
        System.out.println("Hello World");
    }

}
