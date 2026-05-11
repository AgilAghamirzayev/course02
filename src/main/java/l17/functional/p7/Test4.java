package l17.functional.p7;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class Test4 {



    public static void main(String[] args) {

        // a
        // a + 1
        // a =

        AtomicInteger count = new AtomicInteger();

        Function<String, Integer> a = word -> {
            count.incrementAndGet();
            return word.length();
        };

        System.out.println(a.apply("salam"));
        System.out.println(a.apply("salam"));
        System.out.println(a.apply("salam"));
        System.out.println(a.apply("salam"));

        System.out.println(count.get());
    }
}
