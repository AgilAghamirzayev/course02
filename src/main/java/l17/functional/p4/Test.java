package l17.functional.p4;

import l17.functional.p3.Calculator;

public class Test {

    private final int z;
    private final int x;

    public Test(int z, int x) {
        this.z = z;
        this.x = x;
    }

    public static void main(String[] args) {


        Calculator sum0 = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        if (true) {
            System.out.println("test");
        }
        
        Calculator sum = (int a, int b) -> {
            System.out.println("test");
            return a + b;
        };

        Calculator sum1 = (int a, int b) -> a + b;
        Calculator sum2 = (a, b) -> a + b;
        Calculator sum3 = Integer::sum;
        Calculator sum4 = a(12)::sum;

        System.out.println(sum3.calculate(3,5));

        System.out.println(sum2.calculate(3,5));

        Calculator multip = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a * b;
            }
        };

        System.out.println(sum.calculate(1, 2));
        System.out.println(multip.calculate(1, 2));

    }

    public static Test a(int b) {
        return new Test(1,2);
    }

    public  int sum(int a, int b) {
        System.out.println("test");
        return a + b;
    }

}
