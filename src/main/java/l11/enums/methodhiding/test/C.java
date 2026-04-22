package l11.enums.methodhiding.test;

public class C implements A, B {


    @Override
    public void c() {
        A.super.c();
    }
}
