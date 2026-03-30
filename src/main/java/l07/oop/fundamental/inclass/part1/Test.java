package l07.oop.fundamental.inclass.part1;

public class Test {

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.printDetails();
        System.out.println();
        person1.name = "Ali";
        person1.printDetails();

        person1.age = 19;
        person1.gender = "male";

        System.out.println();
        person1.printDetails();

        person1.age = 20;
        person1.printDetails();

        System.out.println();
        person1.walk();
        person1.eat("Pizza");
        person1.sleep();

        System.out.println();
        Person aysu = new Person();
        aysu.name = "Aysu";
        aysu.age = 20;
        aysu.gender = "female";
        aysu.walk();
        aysu.eat("Pasta");
        aysu.sleep();
        aysu.printDetails();
    }

}
