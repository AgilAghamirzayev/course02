package l03.variables.in_class;

public class SoutPractice {

    public static void main(String[] args) {
        System.out.print("Hello World\n");
        System.out.print("Hello World\n\t");

        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");

        System.out.println("-------");
        System.out.printf("%s %d\n", "Hello", 123);
        System.out.println("Hello" +  " " + 123);
        System.out.println("-------");

        System.out.printf("Name: %-10s | Age: %5d | GPA: %.2f%n", "Aylin", 2112121, 3.755);


        System.out.println("------");
        System.out.printf("%s|\n", "Aylin");
        System.out.printf("%s|\n", "Ali");
        System.out.printf("%s|\n", "Aydan");
        System.out.printf("%s|\n", "Aysu");
        System.out.printf("%s|\n", "Ayxan");
        System.out.println("------");

        System.out.println("------");
        System.out.printf("%-10s|\n", "Aylin");
        System.out.printf("%-10s|\n", "Ali");
        System.out.printf("%-10s|\n", "Aydan");
        System.out.printf("%-10s|\n", "Aysu");
        System.out.printf("%-10s|\n", "Ayxan");
        System.out.println("------");


    }
}
