package lesson22.threads.p9;

import java.util.concurrent.Semaphore;

public class ApiRateLimiter {

    private static final Semaphore semaphore =
            new Semaphore(5);

    public static void main(String[] args) {

        Runnable apiRequest = () -> {

            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " calling API...");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " completed");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                semaphore.release();
            }
        };

        for (int i = 1; i <= 20; i++) {
            new Thread(apiRequest, "Request-" + i).start();
        }
    }
}