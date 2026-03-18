package l4.controlflow.loops.inclass;

import java.util.Scanner;

public class Test5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter weekday with number: ");
        String weekDay = scanner.nextLine();

        switch (weekDay) {
            case "1" -> System.out.println("Monday");
            case "2" -> System.out.println("Tuesday");
            case "3" -> System.out.println("Wednesday");
            case "4" -> System.out.println("Thursday");
            case "5" -> System.out.println("Friday");
            case "6" -> System.out.println("Saturday");
            case "7" -> System.out.println("Sunday");
            default -> System.out.println("Invalid input");
        }

    }

}
