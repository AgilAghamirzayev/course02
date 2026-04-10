package l09.oop.inheritance.objectclass.inclass.inheritance.part1.part3;

public class B extends A {
    private int b;

    public B(int a, int b) {
        super(a);
        this.b = b;
    }

    public int getB() {
        return b;
    }
}
