package l07.oop.fundamental.inclass.part4;

public class Test1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Ali");
        person.setAge(11);

        System.out.println(person.getAge() + " " + person.getName());
    }
}
