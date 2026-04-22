package l11.enums.methodhiding.test;

public interface A {
    default void c() {
        System.out.println("A");
    }
}
