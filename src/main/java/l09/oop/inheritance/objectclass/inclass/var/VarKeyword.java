package l09.oop.inheritance.objectclass.inclass.var;

public class VarKeyword {

    // var tricky = "Hello"; // DOES NOT COMPILE

    public void whatTypeAmI() {
        var name = "Hello";
        var size = 7;
        int a, b, c = 10;
        // var x,y,v,z = 10;
    }

//    public void reassignment() {
//        var number = 7;
//        number = 4;
//        number = "five"; // DOES NOT COMPILE
//    }


//    public void doesThisCompile(boolean check) {
//        var question; // → not allowed (must be initialized)
//        question = 1;
//
//        var answer; //→ not allowed (must be initialized)
//
//        if (check) {
//            answer = 2;
//        } else {
//            answer = 3;
//        }
//
//        System.out.println(answer);
//    }

//    public int addition(var a, var b) { // DOES NOT COMPILE
//        return a + b;
//    }

    public static void main(String[] args) {
        println(11);
    }

    static void println(long x) {
        System.out.println("long: x = " + x);
    }

    static void println(int x) {
        System.out.println("int: x = " + x);
    }

    static void println(byte x) {
        System.out.println("byte: x = " + x);
    }

    static void println(short x) {
        System.out.println("short: x = " + x);
    }

}
