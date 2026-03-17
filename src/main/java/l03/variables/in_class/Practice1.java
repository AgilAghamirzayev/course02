package l03.variables.in_class;

public class Practice1 {
    public static void main(String[] args) {
        int num = 10;

        num = 100;
        num = num + 1;
        num = 10;
        System.out.println(num);

        byte maxInt = Byte.MAX_VALUE;

        System.out.println("maxInt = " + maxInt);

        maxInt = (byte) (maxInt + 2);
        System.out.println("maxInt = " + maxInt);

        // what, why, how
    }
}
