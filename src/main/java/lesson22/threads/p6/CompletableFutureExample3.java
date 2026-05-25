package lesson22.threads.p6;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample3 {

    public static void main(String[] args) {

        CompletableFuture.runAsync(() -> System.out.println("Sending email..."));

        CompletableFuture.supplyAsync(() -> {
            return 100;
        }).thenApply(price -> {
            return price * 1.18;
        }).thenAccept(finalPrice -> {
            System.out.println("Final Price: " + finalPrice);
        });

    }
}