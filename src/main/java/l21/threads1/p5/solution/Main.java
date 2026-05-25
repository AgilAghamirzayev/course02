package l21.threads1.p5.solution;


public class Main {
    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                try {
                    sharedQueue.produce(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Producer-Thread");

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                try {
                    sharedQueue.consume();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Consumer-Thread");

        producer.start();
        consumer.start();
    }


}
