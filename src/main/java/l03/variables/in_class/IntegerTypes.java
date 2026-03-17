package l03.variables.in_class;

public class IntegerTypes {

    public static void main(String[] args) {

        byte b = 127;
        byte b1 = -112;
        System.out.println("b = " + b);
        System.out.println("b1 = " + b1);

        System.out.println("-------------");

        short s = 32767;
        short s1 = -32768;
        System.out.println("s = " + s);
        System.out.println("s1 = " + s1);

        System.out.println("-------------");
        int i = Integer.MAX_VALUE;
        int i1 = Integer.MIN_VALUE;
        System.out.println("i = " + i);
        System.out.println("i1 = " + i1);

        System.out.println("-------------");
        long l = 2672621L;
        long l1 = -112123L;
        System.out.println("l = " + l);
        System.out.println("l1 = " + l1);

    }

}
