package l13.collections.part1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {

        Map<Person, Integer> personAndId = new HashMap<>();

        Person ali1 = new Person("Ali", 21);
        Person ali2 = new Person("Ali", 24);
        Person ali3 = new Person("Ali", 22);
        Person ali4 = new Person("Ali", 44);
        Person ahu = new Person("Ahu", 21);

        personAndId.put(ali1, 1);
        personAndId.put(ali2, 2);
        personAndId.put(ali3, 3);
        personAndId.put(ahu, 4);
        personAndId.put(ali4, 4);

        System.out.println(personAndId);
        System.out.println(personAndId.values());
        System.out.println(personAndId.keySet());

        for (Person p : personAndId.keySet()) {

            System.out.println("Key -> " + p + "; Value ->" + personAndId.get(p));
        }



        for (Map.Entry<Person, Integer> entry : personAndId.entrySet()) {
            System.out.println("Key -> " + entry.getKey() + "; Value ->" + entry.getValue());
        }

    }
}
