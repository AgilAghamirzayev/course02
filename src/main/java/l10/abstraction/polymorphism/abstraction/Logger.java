package l10.abstraction.polymorphism.abstraction;

public abstract class Logger {

    public static final int DEFAULT_NUMBER = 10;

    private String level;

    public Logger(String level) {
        this.level = level;
    }

    public void log(String message) {
        System.out.println(level + " " + message);
    }

    public abstract void log(int number);
    public abstract void log(long number);
    public abstract void log(double number);
    public abstract void log(char character);
    public abstract void log(boolean number);

}
