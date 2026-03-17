package l03.variables.in_class;

public class Operator2 {
/*

 */
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int c = 20;

        System.out.println(" a == b is " + (a == b));
        System.out.println(" a != b is " + (a != b));
        System.out.println(" a != c is " + (a != c));
        System.out.println(" a > b is " + (a > b));
        System.out.println(" a < b is " + (a < b));
        System.out.println(" a < c is " + (a < c));
        System.out.println(" a > c is " + (a > c));

        System.out.println(" a >= b is " + (a >= b));
        System.out.println(" a <= b is " + (a <= b));

        System.out.println(true && true);
        System.out.println(false && false);
        System.out.println(true && false && true);

        System.out.println(true || true);
        System.out.println(false || false);
        System.out.println(true || false || false);

        System.out.println(!true);
        System.out.println(!false);
        System.out.println(!true && false);
        System.out.println(!true || !false);




    }
}
