package l17.functional.p1;

@FunctionalInterface
public interface Calculator {

    int calculate(int a, int b);

    default int calculate(int a) {
        int sum = sum(a, 0, 0);
        return calculate(a, 0) + sum;
    }

    private int sum(int a, int b, int c){
        System.out.println("test");
        return a + b + c;
    }

}
