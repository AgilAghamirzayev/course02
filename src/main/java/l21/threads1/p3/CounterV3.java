package l21.threads1.p3;

public class CounterV3 {

    int count = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void increment() { // atomic
        synchronized (lock1) {
            count++; // critical section
        }

        System.out.println(count);
        // read from ram
        // increment
        // write to ram

    }

    public void decrement() { // atomic
        synchronized (lock2) {
            count--; // critical section
        }

        System.out.println(count);
    }

    public int getCount() {
        return count;
    }

}

