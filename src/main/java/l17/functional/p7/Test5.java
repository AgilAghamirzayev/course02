package l17.functional.p7;

import static l17.functional.p7.ConstantOperation.even;
import static l17.functional.p7.ConstantOperation.odd;

import java.util.function.Predicate;

public class Test5 {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (even.test(i)) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        for (int i = 1; i <= 100; i++) {
            if (odd.test(i)) {
                System.out.print(i + " ");
            }
        }

    }


}
