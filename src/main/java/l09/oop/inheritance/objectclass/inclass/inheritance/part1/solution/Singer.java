package l09.oop.inheritance.objectclass.inclass.inheritance.part1.solution;

public class Singer extends Person {
    private String bandName;

    public Singer(String name, int age, String bandName) {
        super(name, age);
        this.bandName = bandName;
    }

    public void sing() {
        System.out.println("Singing");
    }

    public void playGuitar() {
        System.out.println("Playing guitar");
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("Band: " + bandName);
        System.out.println();
    }
}
