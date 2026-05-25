package lesson22.threads.p2;

import java.time.LocalDateTime;
import java.util.concurrent.locks.StampedLock;

public class StampedLockSolution {

    static class Account {
        private int available = 1000;
        private int reserved = 0;

        private final StampedLock lock = new StampedLock();

        public void reserveMoney(int amount) {
            long stamp = lock.writeLock();

            try {
                available -= amount;

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                reserved += amount;
            } finally {
                lock.unlockWrite(stamp);
            }
        }

        public void printBalance() {
            long stamp = lock.tryOptimisticRead();

            int currentAvailable = available;
            int currentReserved = reserved;

            if (!lock.validate(stamp)) {
                stamp = lock.readLock();

                try {
                    currentAvailable = available;
                    currentReserved = reserved;
                } finally {
                    lock.unlockRead(stamp);
                }
            }

            int total = currentAvailable + currentReserved;

            if (total != 1000) {
                System.out.println(
                        "INCONSISTENT READ! available=" + currentAvailable +
                        ", reserved=" + currentReserved +
                        ", total=" + total
                );
            } else {
                System.out.println(LocalDateTime.now() + " Balance: " + total );
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