package l4.controlflow.loops.inclass;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double withdrawalAmount = scanner.nextDouble();
        double accountBalance = 100;

        if (accountBalance <= 0) {
            System.out.println("You have no money");
        } else if (withdrawalAmount > accountBalance) {
            System.out.println("You don't have enough money");
        } else if (withdrawalAmount > 100) {
            System.out.println("You can't withdraw more than 100, You need OTP");
        } else {
            System.out.println("You can withdraw");
        }


    }

}
