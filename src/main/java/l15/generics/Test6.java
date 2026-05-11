package l15.generics;

public class Test6 {

    public static void main(String[] args) {
        Integer i = printNumber(1);
        Double v = printNumber(3.2);

        Number number = printNumberN(1);
        Number number1 = printNumberN(3.3);
    }

    public static <T extends Number> T printNumber(T number) {
        System.out.println(number.doubleValue());
        return number;
    }


    public static Number printNumberN(Number number) {
        System.out.println(number.doubleValue());
        return  number;
    }

}
