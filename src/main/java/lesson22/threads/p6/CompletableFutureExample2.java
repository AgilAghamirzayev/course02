package lesson22.threads.p6;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample2 {

    public static void main(String[] args) {

        CompletableFuture.runAsync(() -> System.out.println("Sending email..."));

    }
}