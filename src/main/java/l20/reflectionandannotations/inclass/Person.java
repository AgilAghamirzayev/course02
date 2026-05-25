package l20.reflectionandannotations.inclass;

public class Person {

    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
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

    private void setPrivateName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Printable
    public void printName() {
        System.out.println(name);
    }


    @Printable
    public void printAge() {
        System.out.println(age);
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
