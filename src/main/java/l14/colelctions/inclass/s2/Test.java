package l14.colelctions.inclass.s2;

import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Set<Person> people = new TreeSet<>();

        people.add(new Person("Ali", 12));
        people.add(new Person("Ali", 11));
        people.add(new Person("Vali", 11));
        people.add(new Person("Aysu", 14));
        people.add(new Person("Ayla", 10));

        people.forEach(System.out::println);
    }
}
