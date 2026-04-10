package l10.abstraction.polymorphism.abstraction;

public class Test {
    public static void main(String[] args) {
        InfoLogger infoLogger = new InfoLogger();
        infoLogger.log(1);
        infoLogger.log(true);

        infoLogger.log("Hello");

        ErrorLogger errorLogger = new ErrorLogger();
        errorLogger.log(1);
        errorLogger.log("Hello");
    }
}
