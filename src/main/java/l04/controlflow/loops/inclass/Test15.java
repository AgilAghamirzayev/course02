package l04.controlflow.loops.inclass;

import java.util.Scanner;

public class Test15 {

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

            switch (operator) {
                case "+" -> System.out.println(a + b);
                case "-" -> System.out.println(a - b);
                case "*" -> System.out.println(a * b);
                case "/" -> System.out.println(a / b);
                default -> {
                    System.out.println("Invalid operator");
                    scanner.close();
                    isContinue = false;
                }
            }

        }


    }

}
