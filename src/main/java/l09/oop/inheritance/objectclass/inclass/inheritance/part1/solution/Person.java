package l09.oop.inheritance.objectclass.inclass.inheritance.part1.solution;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println();
    }

}
