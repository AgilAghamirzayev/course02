package l06.algorithims.datastructures.incalss;

public class Test3 {

    public static void main(String[] args) {

        int a = 1;
        int b = 2;

        String value;
        if (a > b) {
           value = "true";
        } else {
           value = "false";
        }

        System.out.println(value);

        String v2 = a > b ? "true"  : "false";
        System.out.println(v2);


    }
}
