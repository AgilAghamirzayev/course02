package l9.oop.inheritance.objectclass.inclass.inheritance.part2;

public class Employee extends Worker {
    private final long employeeId;
    private final String hireDate;

    public Employee(String name, String birthDate, long employeeId, String hireDate) {
        super(name, birthDate);
        this.employeeId = employeeId;
        this.hireDate = hireDate;
    }

    public String toString() {
        return "Employee{id=" + employeeId + ", hireDate='" + hireDate + "'} " + super.toString();
    }

}