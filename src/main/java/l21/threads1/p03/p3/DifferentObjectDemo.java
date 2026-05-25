package l21.threads1.p03.p3;

public class DifferentObjectDemo {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        new Thread(counter1::increment, "Thread-1").start();
        new Thread(counter2::increment, "Thread-2").start();
    }
}