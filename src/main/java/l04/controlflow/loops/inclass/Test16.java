package l04.controlflow.loops.inclass;

import java.util.Scanner;

public class Test16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;

        while (isContinue) {
            System.out.print("Enter a number: ");
            int a = Integer.parseInt(scanner.next());

            System.out.print("Enter b number: ");
            int b = Integer.parseInt(scanner.next());

            System.out.print("Enter operator: ");
            String operator = scanner.next();

            int result = calculate(operator, a, b);

            print(result, operator);
        }
    }

    public static int calculate(String operator, int a, int b) {
       return switch (operator) {
            case "+" -> sum(a, b);
            case "-" -> sub(a, b);
            case "*" -> mul(a, b);
            case "/" -> div(a, b);
            default -> 0;
       };
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) {
        return a / b;
    }

    public static void print(int number, String operator) {
        System.out.println(operator + ": " + number);
    }

}
