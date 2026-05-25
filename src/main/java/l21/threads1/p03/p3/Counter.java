package l21.threads1.p03.p3;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Counter {

    public synchronized void increment() {
        System.out.println(Thread.currentThread().getName() + " entered increment()");
        sleep(2);
        System.out.println(Thread.currentThread().getName() + " exiting increment()");
    }

    public synchronized void decrement() {
        System.out.println(Thread.currentThread().getName() + " entered decrement()");
        sleep(2);
        System.out.println(Thread.currentThread().getName() + " exiting decrement()");
    }

    private void sleep(long sec) {
        try {
            Thread.sleep(Duration.of(sec, ChronoUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
