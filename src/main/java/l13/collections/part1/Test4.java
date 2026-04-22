package l13.collections.part1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test4 {
    public static void main(String[] args) {

        Map<Person, Integer> personAndId = new LinkedHashMap<>();

        Person ali1 = new Person("Ali", 21);
        Person ali2 = new Person("Ali", 24);
        Person ali3 = new Person("Ali", 22);
        Person ali4 = new Person("Ali", 44);
        Person ahu = new Person("Ahu", 21);

        personAndId.put(ali1, 1);
        personAndId.put(ahu, 4);
        personAndId.put(ali2, 2);
        personAndId.put(ali3, 3);
        personAndId.put(ali4, 4);

        System.out.println(personAndId.values());
        System.out.println(personAndId.keySet());


    }
}
