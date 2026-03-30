package l07.oop.fundamental.inclass.part1;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Person person = new Person();
        System.out.print("Enter name: ");
        person.name = scanner.next();
        System.out.print("Enter age: ");
        person.age = Integer.parseInt(scanner.next());
        System.out.print("Enter gender: ");
        person.gender = scanner.next();

        System.out.println("Details:");
        person.printDetails();



    }

}
