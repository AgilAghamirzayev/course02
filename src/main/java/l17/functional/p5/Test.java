package l17.functional.p5;

public class Test {
    public static void main(String[] args) {
        Printer personPrinter = person -> System.out.println(person.getName());
        Printer println = System.out::println;

        personPrinter.print(new Person("Ali"));
        println.print(new Person("Ali"));
    }
}
