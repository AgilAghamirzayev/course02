package l9.oop.inheritance.objectclass.inclass.inheritance.part1.solution;

public class Dancer extends Person {

    private String groupName;

    public Dancer(String name, int age, String groupName) {
        super(name, age);
        this.groupName = groupName;
    }

    public void dance() {
        System.out.println("Dancing");
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("Group: " + groupName);
        System.out.println();
    }

}
