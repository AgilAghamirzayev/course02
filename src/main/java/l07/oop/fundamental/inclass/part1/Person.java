package l07.oop.fundamental.inclass.part1;

public class Person {

    public String name;
    public int age;
    public String gender;
    public PersonAddress address;

    public void walk() {
        System.out.printf("%s is walking%n", name);
    }

    public void eat(String foodName) {
        System.out.printf("%s is eating %s%n",name, foodName);
    }

    public void sleep() {
        System.out.println("%s is sleeping".formatted(name));
    }

    public void work() {
        System.out.println("%s is working".formatted(name));
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        if (address != null) {
            System.out.println("Address: " + address.getAddress());
        } else {
            System.out.println("Address: No address available");
        }
        System.out.println();
    }

}
