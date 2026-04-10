package l09.oop.inheritance.objectclass.inclass.staticc.part2;

public class StaticExecutionDemo {

    static int staticVar = print("1. Static variable initialized");
    int instanceVar = print("6. Instance variable initialized");

    {
        print("7. Instance initializer block executed");
    }

    static {
        print("2. Static block #1 executed");
    }

    static {
        print("3. Static block #2 executed");
    }


    {
        print("7. Instance initializer block executed");
    }

    {

        print("8. Instance initializer block #2 executed");
    }

    public StaticExecutionDemo() {
        print("9. Constructor executed");
    }

    public static void staticMethod() {
        print("4. Static method called");
    }

    public void instanceMethod() {
        System.out.println(instanceVar);
        print("10. Instance method called");
    }

    public static int print(String message) {
        System.out.println(message);
        return 0;
    }


}