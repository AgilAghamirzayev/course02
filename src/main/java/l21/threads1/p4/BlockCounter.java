package l21.threads1.p4;

public class BlockCounter {
    private int count = 0;
    private final Object lock = new Object();

    public void increment() {
        System.out.println(Thread.currentThread().getName() + " before block");

        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " entered synchronized block");
            count++;
            sleep(3000);
            System.out.println(Thread.currentThread().getName() + " exiting synchronized block");
        }

        System.out.println(Thread.currentThread().getName() + " after block");
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}