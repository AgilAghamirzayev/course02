package lesson22.threads.p6;

import java.util.concurrent.CompletableFuture;

public class ThenCombineExample {

    public static void main(String[] args) {

        CompletableFuture<Integer> azerisiq = CompletableFuture.supplyAsync(() -> 120);
        CompletableFuture<Integer> azersu = CompletableFuture.supplyAsync(() -> 50);

        azerisiq.thenCombine(azersu, Integer::sum)
                .thenAccept(total -> System.out.println("Total debt: " + total));
    }
}