package l9.oop.inheritance.objectclass.inclass.inheritance.part2;

import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    private final double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, long employeeId, String hireDate, double annualSalary) {
        super(name, birthDate, employeeId, hireDate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public boolean isRetired() {
        return isRetired;
    }

    @Override
    public double collectPay() {
        double monthlyPay = annualSalary / 12.0;
        return isRetired ? monthlyPay * 0.9 : monthlyPay; // Pension example
    }

    public void retire() {
        terminate(LocalDate.now().toString());
        isRetired = true;
        System.out.println(getName() + " is now retired.");
    }

}