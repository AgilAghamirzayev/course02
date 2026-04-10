package l09.oop.inheritance.objectclass.inclass.inheritance.part2;

public class Worker {

    private final String name;
    private final String birthDate;

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return 2026 - Integer.parseInt(birthDate.substring(birthDate.length() - 4));
    }

    public double collectPay() {
        return 0.0;
    }

    public void terminate(String endDate) {
        System.out.println("Worker " + name + " terminated on " + endDate);
    }

    public String toString() {
        return "Worker{name='" + name + "', birthDate='" + birthDate + "'}";
    }

}