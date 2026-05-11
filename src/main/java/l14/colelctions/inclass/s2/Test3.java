package l14.colelctions.inclass.s2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<Person1> people = new ArrayList<>();

        people.add(new Person1("Ali", 11));
        people.add(new Person1("Ali", 11));
        people.add(new Person1("Ai", 11));
        people.add(new Person1("Vali", 11));
        people.add(new Person1("Aysu", 14));
        people.add(new Person1("Ayla", 10));

        people.stream().sorted(Comparator.comparing(p -> p.getName()))
                .forEach(System.out::println);

        System.out.println();
        people.forEach(System.out::println);

        people.sort(Comparator.comparing(Person1::getAge).reversed().thenComparing(Person1::getName));

        //Collections.sort(people, (a, b) -> a.getName().compareTo(b.getName()));
        System.out.println();
        people.forEach(System.out::println);

    }
}
