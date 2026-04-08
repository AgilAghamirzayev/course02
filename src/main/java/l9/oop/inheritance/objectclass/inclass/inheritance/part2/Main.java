package l9.oop.inheritance.objectclass.inclass.inheritance.part2;

public class Main {
    public static void main(String[] args) {
        SalariedEmployee ali = new SalariedEmployee("Ali", "01/01/1990", 1001L, "01/01/2020", 60_000);
        System.out.println("Ali's Monthly Pay: " + ali.collectPay());

        HourlyEmployee huseyn = new HourlyEmployee("Veli", "05/05/1995", 1002L, "15/06/2021", 25);
        System.out.println("Veli's Monthly Pay: " + huseyn.collectPay());

        ali.retire();
        System.out.println("Ali's Monthly Pay: " + ali.collectPay());
        System.out.println("Veli's Monthly Pay: " + huseyn.collectPay());

    }
}