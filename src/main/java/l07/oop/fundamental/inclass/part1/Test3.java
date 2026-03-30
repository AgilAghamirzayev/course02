package l07.oop.fundamental.inclass.part1;

public class Test3 {

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Ali";
        person.age = 19;
        person.gender = "Male";

        person.printDetails();

        PersonAddress personAddress = new PersonAddress();
        personAddress.street = "Tabriz Street";
        personAddress.city = "Baku";

        person.address = personAddress;

        person.printDetails();


    }

}
