package lesson22.threads.p7;

import java.util.concurrent.CountDownLatch;

public class SystemStartup {

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            simulate("Database");
            latch.countDown();
        }).start();

        new Thread(() -> {
            simulate("Kafka");
            latch.countDown();
        }).start();

        new Thread(() -> {
            simulate("Redis");
            latch.countDown();
        }).start();

        System.out.println("Waiting systems...");

        latch.await();

        System.out.println("All systems ready. Application started!");
    }

    static void simulate(String system) {

        System.out.println(system + " connecting...");

        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(system + " connected!");
    }
}