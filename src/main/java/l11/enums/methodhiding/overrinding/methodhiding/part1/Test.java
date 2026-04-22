package l11.enums.methodhiding.overrinding.methodhiding.part1;

public class Test {
    public static void main(String[] args) {
        Cat myCat = new Cat();

        myCat.testInstanceMethod();
        myCat.testClassMethod();
    }
}
