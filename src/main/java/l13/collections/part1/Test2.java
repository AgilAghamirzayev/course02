package l13.collections.part1;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {

        Map<Person, Integer> personAndId = new HashMap<>();

        Person ali1 = new Person("Ali", 21);
        Person ali2 = new Person("Ali", 21);
        Person ali3 = new Person("Ali", 22);
        Person ahu = new Person("Ahu", 21);

        personAndId.put(ali1, 1);
        personAndId.put(ahu, 2);

        System.out.println(ali1.equals(ali2)); // true
        System.out.println(ali1.equals(ali3)); // false
        System.out.println(ali1 == ali2);      // false
        System.out.println(ali1.hashCode());
        System.out.println(ali2.hashCode());
        System.out.println(ali3.hashCode());

        System.out.println(personAndId.get(ali1)); // 1
        System.out.println(personAndId.get(ali2)); // 1
        System.out.println(personAndId.get(ali3)); // null

        for (int i = 0; i < personAndId.size(); i++) {
            System.out.println(personAndId.get(i));
        }

//        for (Map.Entry<Person, Integer> entry : personAndId.entrySet()) {}

    }
}
