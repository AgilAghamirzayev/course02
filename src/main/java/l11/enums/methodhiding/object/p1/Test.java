package l11.enums.methodhiding.object.p1;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Test test1 = new Test();
        System.out.println(test == test);
        System.out.println(test == test1);
    }
}
