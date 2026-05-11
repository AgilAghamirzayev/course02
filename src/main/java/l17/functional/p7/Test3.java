package l17.functional.p7;

import java.util.function.Function;

public class Test3 {

    public static void main(String[] args) {
        int[] count = {0};
        Function<String, Integer> a = word -> {
            count[0]++;
            return word.length();
        };

        System.out.println(a.apply("salam"));
        System.out.println(a.apply("salam"));
        System.out.println(a.apply("salam"));
        System.out.println(a.apply("salam"));

        System.out.println(count[0]);
    }
}
