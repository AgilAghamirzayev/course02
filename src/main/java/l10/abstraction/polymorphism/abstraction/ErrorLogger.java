package l10.abstraction.polymorphism.abstraction;

public class ErrorLogger extends Logger {

    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public ErrorLogger() {
        super("ERROR");
    }

    @Override
    public void log(int number) {
        System.out.println(RED + "ErrorLogger: " + number + RESET);
    }

    @Override
    public void log(long number) {
        System.out.println("ErrorLogger: " + number);
    }

    @Override
    public void log(double number) {
        System.out.println("ErrorLogger: " + number);
    }

    @Override
    public void log(char character) {
        System.out.println("ErrorLogger: " + character);
    }

    @Override
    public void log(boolean number) {
        System.out.println("ErrorLogger: " + number);
    }

}
