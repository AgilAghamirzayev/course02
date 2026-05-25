package lesson22.threads.p2;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockSolution {

    static class Account {
        private int available = 1000;
        private int reserved = 0;

        private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void reserveMoney(int amount) {
            lock.writeLock().lock();
            try {
                available -= amount;

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                reserved += amount;
            } finally {
                lock.writeLock().unlock();
            }
        }

        // READ LOCK
        public void printBalance() {
            lock.readLock().lock();
            try {
                int total = available + reserved;

                if (total != 1000) {
                    System.out.println("INCONSISTENT READ! available=" + available + ", reserved=" + reserved + ", total=" + total);
                } else {
                    System.out.println(LocalDateTime.now() + " Balance: " + total );
                }
            } finally {
                lock.readLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        Account account = new Account();

        Thread writer = new Thread(() -> {
            while (true) {
                account.reserveMoney(1);
                account.reserveMoney(-1);
            }
        }, "Writer");

        Thread reader1 = new Thread(() -> {
            while (true) {
                account.printBalance();
            }
        }, "Reader-1");

        Thread reader2 = new Thread(() -> {
            while (true) {
                account.printBalance();
            }
        }, "Reader-2");

        writer.start();
        reader1.start();
        reader2.start();
    }
}