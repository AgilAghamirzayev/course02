package l11.enums.methodhiding.test;

public interface B {
    default void c() {
        System.out.println("B");
    }
}
