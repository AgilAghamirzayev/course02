package l03.variables.in_class;

public class CastingPractice {
    public static void main(String[] args) {
        double d = 128.88;
        byte i = (byte) d;
        d = (int) d;
        System.out.println(i);
        System.out.println(d);

        System.out.println((int) d);

        int a = 6;
        double b = 1.1;
        System.out.println(a + b);

        int x = 10;
        int y = 4;
        int z = x / y;
        double aa = (double) x / (double) y;
        double bb = (double) x/y;

        System.out.println(z);
        System.out.println(aa);
        System.out.println(bb);
    }
}
