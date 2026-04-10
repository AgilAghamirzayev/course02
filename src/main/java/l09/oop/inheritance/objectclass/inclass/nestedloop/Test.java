package l09.oop.inheritance.objectclass.inclass.nestedloop;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.test());
    }

    public  int test() {
        Point point = new Point(1, 2);
        return point.x + point.y;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
