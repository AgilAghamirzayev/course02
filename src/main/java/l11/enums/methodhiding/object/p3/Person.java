package l11.enums.methodhiding.object.p3;

import java.util.Objects;

public class Person {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof Person)) {
//            return false;
//        }
//        Person person = (Person) obj;
//        return this.name.equals(person.name) && this.age == person.age;
//    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

}
