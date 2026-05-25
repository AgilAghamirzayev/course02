package l21.threads1.p5.problem;

public class Main {
    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                sharedQueue.produce(i);
                sleep(500);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                sharedQueue.consume();
                sleep(1000);
            }
        });

        producer.start();
        consumer.start();
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
