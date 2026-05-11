package l17.functional.p2;

public class Test {
    public static void main(String[] args) {
        Calculator calculator = new SumCalculator();
        System.out.println(calculator.calculate(1, 2));

        MultiplyCalculator multiplyCalculator = new MultiplyCalculator();
        System.out.println(multiplyCalculator.calculate(1, 2));
    }
}
