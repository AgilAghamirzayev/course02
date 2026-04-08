package l8.exam;

import l8.exam.part1.Pet;
import l8.exam.part2.Person;

public class Test1 {

    public static void main(String[] args) {

        l8.exam.part1.Person person = new l8.exam.part1.Person(12);
        Person person1 = new Person(2022);
        System.out.println(person.getAge());
        System.out.println(person1.birthDate);

        Pet pet = new Pet("Cat");
        System.out.println(pet.name);

        // Wrapper classes

    }

}

