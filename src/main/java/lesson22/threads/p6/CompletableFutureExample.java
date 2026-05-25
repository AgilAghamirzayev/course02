package lesson22.threads.p6;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    return "Payment Success";
                });

        System.out.println("Doing other work...");

        future.thenAccept(result -> System.out.println("Result: " + result));

        System.out.println("Main thread continues...");
    }
}