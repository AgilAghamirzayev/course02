package l17.functional.p7;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class ConstantOperation {

    private ConstantOperation() {
    }

    public static final Predicate<Integer> even = a -> a % 2 == 0;
    public static Predicate<Integer> odd = a -> a % 2 != 0;
    public static Predicate<Integer> positive = a -> a > 0;
    public static Predicate<Integer> negative = a -> a < 0;
    public static Predicate<Integer> zero = a -> a == 0;
    public static Predicate<Integer> nonZero = a -> a != 0;

    public static Predicate<Integer> prime = a -> {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    };

    public static Predicate<Integer> notPrime = a -> !prime.test(a);

    public static Function<Integer, Integer> square = a -> a * a;
    public static Function<Integer, Integer> cube = a -> a * a * a;
    public static Function<Integer, Integer> sqrt = a -> (int) Math.sqrt(a);
    public static Function<Integer, Integer> abs = Math::abs;
    public static Function<Integer, Integer> negate = a -> -a;
    public static Function<Integer, Integer> increment = a -> a + 1;
    public static Function<Integer, Integer> decrement = a -> a - 1;
    public static BiFunction<Integer, Integer, Integer> sum =  (a, b) -> a + b;
    public static BiFunction<Integer, Integer, Integer> sub =  (a, b) -> a - b;
    public static BiFunction<Integer, Integer, Integer> mul =  (a, b) -> a * b;
    public static BiFunction<Integer, Integer, Integer> div =  (a, b) -> a / b;
    public static BiFunction<Integer, Integer, Integer> mod =  (a, b) -> a % b;

    public static Supplier<Integer> random = () -> (int) (Math.random() * 100);
    public static Supplier<Integer> random1 = () -> (int) (Math.random() * 1000);
    public static Supplier<Integer> random2 = () -> (int) (Math.random() * 10000);

    public static Consumer<Integer> print = System.out::println;

}
