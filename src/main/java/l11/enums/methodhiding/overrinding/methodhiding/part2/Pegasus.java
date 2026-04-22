package l11.enums.methodhiding.overrinding.methodhiding.part2;

public class Pegasus extends Horse implements Flyer, Mythical {

    // Instance methods are preferred over interface default methods.
    public static void main(String... args) {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
}