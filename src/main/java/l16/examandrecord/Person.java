package l16.examandrecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Person {

    private final String name;
    private final List<String> courses;

    public Person(String name, List<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(courses, person.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, courses);
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", courses=" + courses + '}';
    }

}
