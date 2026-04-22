package l11.enums.methodhiding.object.p1;

public class SingletonTest {
    private SingletonTest() {}

    private static final SingletonTest INSTANCE = new SingletonTest();

    public static SingletonTest getInstance() {
        return INSTANCE;
    }

}
