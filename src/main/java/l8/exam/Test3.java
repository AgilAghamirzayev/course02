package l8.exam;


public class Test3 {

    public static void main(String[] args) {

        Integer a = 127;
        Integer b = Integer.valueOf(127);

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a == b); //

        Integer c = 128;
        Integer d = 128;
        System.out.println(c);
        System.out.println(d.hashCode());
        System.out.println(c == d);

    }

}

