package l9.oop.inheritance.objectclass.inclass.inheritance.part3;

public class Test {
    private int a;

    public Test(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Test{" +
                "a=" + a +
                '}';
    }


}
