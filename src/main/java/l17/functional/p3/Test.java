package l17.functional.p3;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        Calculator sum = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };

        Calculator multip = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a * b;
            }
        };

        System.out.println(sum.calculate(1, 2));
        System.out.println(multip.calculate(1, 2));
    }
}
