package l05.arrays.strings.inclass.inclass;

public class StringPractice1 {
    public static void main(String[] args) {

        String name1 = new String("Test");
        String name2 = new String("Test");
        String name3 = "Test";
        String name4 = "Test";
        String name5 = name1.intern();
        String name6 = "Test-1";

        System.out.println(name1 == name2);  // false
        System.out.println(name1 == name3);  // false
        System.out.println(name3 == name4);  // true
        System.out.println(name3 == name5);  // true
        System.out.println(name3 == name6);  // false
        System.out.println(name1 == name5);  // false

        System.out.println(name1.equals(name2));  // true
        System.out.println(name3.equals(name5));  // true
        System.out.println(name3.equals(name4));  // true
        System.out.println(name3.equals(name5));  // true
        System.out.println(name3.equals(name6));  // false
        System.out.println(name1.equals(name5));  // true

        String first = "rat" + 1;
        String second = "r" + "a" + "t" + "1";
        String third = "r" + "a" + "t" + new String("1");

        System.out.println(first == second);           // ?
        System.out.println(first == second.intern());  // ?
        System.out.println(first == third);            // ?
        System.out.println(first == third.intern());   // ?

    }
}
