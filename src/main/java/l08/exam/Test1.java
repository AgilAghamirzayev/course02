package l08.exam;

import l08.exam.part1.Person;
import l08.exam.part1.Pet;

public class Test1 {

    public static void main(String[] args) {

        Person person = new Person(12);
        l08.exam.part2.Person person1 = new l08.exam.part2.Person(2022);
        System.out.println(person.getAge());
        System.out.println(person1.birthDate);

        Pet pet = new Pet("Cat");
        System.out.println(pet.name);

        // Wrapper classes

    }

}

