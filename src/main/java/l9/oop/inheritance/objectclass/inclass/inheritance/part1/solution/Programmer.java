package l9.oop.inheritance.objectclass.inclass.inheritance.part1.solution;

public class Programmer extends Person {

    private String companyName;

    public Programmer(String name, int age, String companyName) {
        super(name, age);
        this.companyName = companyName;
    }

    public void code() {
        System.out.println("Code");
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("Company: " + companyName);
        System.out.println();
    }

}
