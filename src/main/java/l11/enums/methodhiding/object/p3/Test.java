package l11.enums.methodhiding.object.p3;

public class Test extends Object {
    public static void main(String[] args) {
        Person p1 = new Person("John", 1);
        Person p2 = new Person("John", 1);
        Person p3 = new Person("Tom", 2);
        Person p4 = new Person("John", 2);
        Animal animal = new Animal("Jerry");


//        System.out.println(p2 == p1);
        System.out.println(p2.equals(p1));
        System.out.println(p2.equals(p3));
        System.out.println(p2.equals(animal));
        System.out.println(p2.equals(null));
        System.out.println(p2.equals(p4));
    }
}
