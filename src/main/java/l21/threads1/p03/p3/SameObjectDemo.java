package l21.threads1.p03.p3;

public class SameObjectDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();

        new Thread(counter::increment, "Thread-1").start();
        new Thread(counter::decrement, "Thread-2").start();
    }
}
