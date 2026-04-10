package l10.abstraction.polymorphism.abstraction;

public class InfoLogger extends Logger {

    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";

    public InfoLogger() {
        super("INFO");
    }

    @Override
    public void log(int number) {
        System.out.println(GREEN + "InfoLogger: " + number + RESET);
    }

    @Override
    public void log(long number) {
        System.out.println("InfoLogger: " + number);
    }

    @Override
    public void log(double number) {
        System.out.println("InfoLogger: " + number);
    }

    @Override
    public void log(char character) {
        System.out.println("InfoLogger: " + character);
    }

    @Override
    public void log(boolean bool) {
        System.out.println("InfoLogger: b -> " + bool);
    }

}
