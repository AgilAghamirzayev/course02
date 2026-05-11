package l17.functional.p7;

import java.util.Random;
import java.util.function.Supplier;

public class Test2 {
    static Supplier<Integer> integerPrivilegedAction = () -> (int) (new Random().nextInt(1, 100));

    public static void main(String[] args) {
        int c = 0;
        while (true) {
            c++;
            if (integerPrivilegedAction.get() == 99) {
                System.out.println(c);
                break;
            }
        }

    }
}
