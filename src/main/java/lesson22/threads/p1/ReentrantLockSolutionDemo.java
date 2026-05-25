package lesson22.threads.p1;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSolutionDemo {

    private final ReentrantLock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("outerMethod lock aldı");
            System.out.println("Hold count after outer lock: " + lock.getHoldCount());

            innerMethod();

            System.out.println("outerMethod davam edir");
        } finally {
            lock.unlock();
            System.out.println("outerMethod unlock etdi");
        }
    }

    public void innerMethod() {
        lock.lock();
        try {
            System.out.println("innerMethod də eyni lock-u aldı");
            System.out.println("Hold count inside inner: " + lock.getHoldCount());
        } finally {
            lock.unlock();
            System.out.println("innerMethod unlock etdi");
            System.out.println("Hold count after inner unlock: " + lock.getHoldCount());
        }
    }

    public static void main(String[] args) {
        ReentrantLockSolutionDemo demo = new ReentrantLockSolutionDemo();
        demo.outerMethod();
    }
}