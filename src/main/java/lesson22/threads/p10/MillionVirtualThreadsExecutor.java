package lesson22.threads.p10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MillionVirtualThreadsExecutor {

    public static void main(String[] args) throws Exception {

        int count = 1_000_000;

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < count; i++) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(60_000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }

            System.out.println("Submitted " + count + " virtual threads");
        }
    }
    
}