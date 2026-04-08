package l9.oop.inheritance.objectclass.inclass.inheritance.part1.problem;

public class Singer {
    private String name;
    private int age;
    private String bandName;

    public Singer(String name, int age, String bandName) {
        this.name = name;
        this.age = age;
        this.bandName = bandName;
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

    public void sing() {
        System.out.println("Singing");
    }

    public void playGuitar() {
        System.out.println("Playing guitar");
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Band: " + bandName);
        System.out.println();
    }
}
