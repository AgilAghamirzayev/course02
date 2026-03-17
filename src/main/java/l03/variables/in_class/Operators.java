package l03.variables.in_class;

public class Operators {
/*

 */
    public static void main(String[] args) {
        int a = 10;
        a++; // a = a + 1; --  a += 1;

        System.out.println(a);
        a--; // a = a - 1;
        System.out.println(a);

        a *= 10; // a = a * 10;
        System.out.println(a);

        ++a;
        System.out.println(a);
        System.out.println(++a);
        System.out.println(a++);
        System.out.println(a);

        a = 10;

//        System.out.println(++a + a);
//        System.out.println(++a + a++);
        System.out.println(a++ + ++a);

        // 22 // 23
        System.out.println(a); // 12


        int qa = 34 / 10;
        int qd = 34 % 10;

        System.out.println(qa);
        System.out.println(qd);




    }
}
