package l09.oop.inheritance.objectclass.inclass.inheritance.part1.problem;

public class Programmer {
    private String name;
    private int age;
    private String companyName;

    public Programmer(String name, int age, String companyName) {
        this.name = name;
        this.age = age;
        this.companyName = companyName;
    }

    public void learn() {
        System.out.println("Learning");
    }

    public void walk() {
        System.out.println("Walking");
    }

    public void eat() {
        System.out.println("Eating");
    }

    public void code() {
        System.out.println("Coding");
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Company: " + companyName);
        System.out.println();
    }
}
