package l14.colelctions.inclass.s2;

import java.util.Objects;

public class Person1  implements Comparable<Person1> {

    private String name;
    private Integer age;

    public Person1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person1 person = (Person1) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "[name: %s, age: %s]".formatted(name, age);
    }

    @Override
    public int compareTo(Person1 o) {
        return 0;
    }

}
