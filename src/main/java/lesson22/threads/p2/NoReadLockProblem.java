package lesson22.threads.p2;

import java.util.concurrent.locks.ReentrantLock;

public class NoReadLockProblem {

    static class Account {
        private int available = 1000;
        private int reserved = 0;

        private final ReentrantLock writeLock = new ReentrantLock();

        // WRITE zamanı lock var
        public void reserveMoney(int amount) {
            writeLock.lock();
            try {
                available -= amount;

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                reserved += amount;
            } finally {
                writeLock.unlock();
            }
        }

        // READ zamanı lock YOXDUR
        public void printBalance() {
            int total = available + reserved;

            if (total != 1000) {
                System.out.println("INCONSISTENT READ! available=" + available + ", reserved=" + reserved + ", total=" + total);
            } else {
                System.out.println("Balance: " + total);
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

        Thread reader = new Thread(() -> {
            while (true) {
                account.printBalance();
            }
        }, "Reader");

        writer.start();
        reader.start();
    }
}