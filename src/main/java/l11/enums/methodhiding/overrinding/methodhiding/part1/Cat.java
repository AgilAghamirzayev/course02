package l11.enums.methodhiding.overrinding.methodhiding.part1;

public class Cat extends Animal {

    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }

    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

}