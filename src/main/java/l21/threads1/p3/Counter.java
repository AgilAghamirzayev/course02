package l21.threads1.p3;

public class Counter {

    int count = 0;

    public synchronized void increment() { // atomic
        // read from ram
        // increment
        // write to ram
        count++;
    }

    public int getCount() {
        return count;
    }

}

