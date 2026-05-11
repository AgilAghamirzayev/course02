package l17.functional.p6;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Randomize random = () ->  0;
        Randomize random1 = () -> (int) (Math.random() * 100);
        Randomize random2 = () -> (int) (Math.random() * 1000);
        Randomize random3 = () -> (int) (Math.random() * 10000);

        Runnable random4 =  Math::random;

        System.out.println(random1.generate());
        System.out.println(random2.generate());
        System.out.println(random3.generate());

    }
}
