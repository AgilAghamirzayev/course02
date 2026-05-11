package l17.functional.p7;

import java.util.function.Consumer;

public class Test1 {

    public static final Consumer<Integer> INTEGER_CONSUMER = a -> System.out.println(a + 10);
    public static final Consumer<Integer> INTEGER_CONSUMER1 = a -> System.out.println(a + 20);
    public static final Consumer<Integer> INTEGER_CONSUMER2 = a -> System.out.println(a + 30);

    public static void main(String[] args) {

        Consumer<Integer> c1 = System.out::println;

        c1.andThen(INTEGER_CONSUMER)
                .andThen(INTEGER_CONSUMER1)
                .andThen(INTEGER_CONSUMER2)
                .accept(20);

    }
}
