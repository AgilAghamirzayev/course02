package l07.oop.fundamental.inclass.part2;

public class Test1 {
    public static void main(String[] args) {
        Person person = new Person();

        person.name("Ali");
        person.age(11);

        System.out.println(person.age() + " " + person.name());

    }
}
