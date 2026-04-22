package l11.enums.methodhiding.object.p2;

public class Test {
    public static void main(String[] args) {
        LazySingleton l =  LazySingleton.getInstance();
        LazySingleton l1 =  LazySingleton.getInstance();
        System.out.println(l == l1);
    }
}
