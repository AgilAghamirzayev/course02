package lesson22.threads.p9;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        Runnable task = () -> {

            try {
                System.out.println(Thread.currentThread().getName() + " waiting...");

                semaphore.acquire();

                System.out.println(Thread.currentThread().getName() + " acquired permit");

                Thread.sleep(3000);

                System.out.println(Thread.currentThread().getName() + " releasing permit");

                semaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        };

        for (int i = 1; i <= 10; i++) {
            new Thread(task, "User-" + i).start();
        }
    }
}