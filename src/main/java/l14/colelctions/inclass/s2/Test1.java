package l14.colelctions.inclass.s2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test1 {
    public static void main(String[] args) {


        Set<Person1> people = new TreeSet<>(Comparator.comparing(p -> p.getName()));

        people.add(new Person1("Ali", 12));
        people.add(new Person1("Ali", 11));
        people.add(new Person1("Vali", 11));
        people.add(new Person1("Aysu", 14));
        people.add(new Person1("Ayla", 10));

        people.forEach(System.out::println);
    }
}
