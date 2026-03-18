package l4.controlflow.loops.inclass;

public class Test2 {

    public static void main(String[] args) {
        double withdrawalAmount = 100;
        double accountBalance = 100;

        if (accountBalance <= 0) {
            System.out.println("You have no money");
        }  else if (withdrawalAmount > accountBalance) {
            System.out.println("You don't have enough money");
        } else if (withdrawalAmount > 100) {
            System.out.println("You can't withdraw more than 100, You need OTP");
        } else {
            System.out.println("You can withdraw");
        }


    }

}
