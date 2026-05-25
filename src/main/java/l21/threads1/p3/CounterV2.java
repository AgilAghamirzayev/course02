package l21.threads1.p3;

public class CounterV2 {

    int count = 0;

    public  void increment() { // atomic
        synchronized (this) {
            count++; // critical section
        }

        System.out.println(count);
        // read from ram
        // increment
        // write to ram

    }

    public int getCount() {
        return count;
    }

}

