package l21.threads1.p4;

public class SynchronizedBlockDemo2 {
    public static void main(String[] args) {
        BlockCounter counter = new BlockCounter();

        new Thread(counter::increment, "Thread-1").start();
        new Thread(counter::increment, "Thread-2").start();
    }
}