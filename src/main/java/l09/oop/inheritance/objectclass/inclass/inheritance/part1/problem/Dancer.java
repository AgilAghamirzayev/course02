package l09.oop.inheritance.objectclass.inclass.inheritance.part1.problem;

public class Dancer {

    private String name;
    private int age;
    private String groupName;

    public Dancer(String name, int age, String groupName) {
        this.name = name;
        this.age = age;
        this.groupName = groupName;
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

    public void dance() {
        System.out.println("Dancing");
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Group: " + groupName);
        System.out.println();
    }

}
