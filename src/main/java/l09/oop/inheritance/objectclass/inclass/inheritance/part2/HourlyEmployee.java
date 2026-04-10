package l09.oop.inheritance.objectclass.inclass.inheritance.part2;

public class HourlyEmployee extends Employee {
    private final double hourlyPayRate;

    public HourlyEmployee(String name, String birthDate, long employeeId, String hireDate, double hourlyPayRate) {
        super(name, birthDate, employeeId, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    @Override
    public double collectPay() {
        // Assuming 40 hours per week * 4 weeks = 160 hours per month
        return hourlyPayRate * 160;
    }

    public double getWeeklyPay(int hoursWorked) {
        double regularPay = Math.min(hoursWorked, 40) * hourlyPayRate;
        double overtimePay = Math.max(hoursWorked - 40, 0) * hourlyPayRate * 1.5;
        return regularPay + overtimePay;
    }

    public String toString() {
        return "HourlyEmployee{hourlyPayRate=" + hourlyPayRate + "} " + super.toString();
    }
}