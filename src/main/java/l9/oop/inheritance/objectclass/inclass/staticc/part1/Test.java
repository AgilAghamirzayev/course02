package l9.oop.inheritance.objectclass.inclass.staticc.part1;


public class Test {
    public static void main(String[] args) {
        System.out.println(Counter.count);

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();

        System.out.println(counter1.count);
        System.out.println(counter2.count);
        System.out.println(counter3.count);
        System.out.println(Counter.count);
    }
}
