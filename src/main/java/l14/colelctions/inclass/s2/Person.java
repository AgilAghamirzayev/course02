package l14.colelctions.inclass.s2;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
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
        Person person = (Person) o;
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
    public int compareTo(Person o) {
        if (name.compareTo(o.name) == 0) {
            return age.compareTo(o.age);
        }
        return name.compareTo(o.name) ;
    }

}
