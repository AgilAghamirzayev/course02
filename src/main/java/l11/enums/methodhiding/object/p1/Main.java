package l11.enums.methodhiding.object.p1;

public class Main {
    public static void main(String[] args) {
        SingletonTest a = SingletonTest.getInstance();
        SingletonTest b = SingletonTest.getInstance();

        System.out.println(a == b);
    }
}
