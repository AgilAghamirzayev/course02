package l04.controlflow.loops.inclass;

import java.util.Scanner;

public class Test8 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String weekDayNum = "";

        while (!weekDayNum.equals("exit")) {
            System.out.print("Enter weekday with number: ");
            weekDayNum = scanner.nextLine();

            String weekDay = switch (weekDayNum) {
                case "1" -> "Monday";
                case "2" -> "Tuesday";
                case "3" -> "Wednesday";
                case "4" -> "Thursday";
                case "5" -> "Friday";
                case "6" -> "Saturday";
                case "7" -> "Sunday";
                case "exit" -> {
                    scanner.close();
                   yield "Exiting...";
                }
                default -> "Invalid input";
            };

            System.out.println(weekDay);
        }


    }

}
