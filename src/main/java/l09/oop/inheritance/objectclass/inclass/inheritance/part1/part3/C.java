package l09.oop.inheritance.objectclass.inclass.inheritance.part1.part3;

public class C extends B {
    private int c;

    public C(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    public int getC() {
        return c;
    }

    public void print() {
        System.out.println(getA() + " " + getB() + " " + getC());
    }

}
