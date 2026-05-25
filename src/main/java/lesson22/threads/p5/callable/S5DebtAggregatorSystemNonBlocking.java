package lesson22.threads.p5.callable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class S5DebtAggregatorSystemNonBlocking {

    public record DebtResult(
            String provider,
            Double debt,
            boolean success,
            String message
    ) {
        public static DebtResult of(String provider, Double debt, boolean success, String message) {
            return new DebtResult(provider, debt, success, message);
        }
    }

    private static CompletableFuture<DebtResult> requestProviderAsync(
            String provider,
            long responseDelayMs,
            double debt,
            ExecutorService executor
    ) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(responseDelayMs);
                return DebtResult.of(provider, debt, true, "Success");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupted");
            }
        }, executor);
    }

    private static DebtResult timeoutResult(String provider) {
        return DebtResult.of(provider, null, false, "Provider timeout");
    }

    private static DebtResult errorResult(String provider, Throwable error) {
        return DebtResult.of(provider, null, false, unwrapMessage(error));
    }

    private static String unwrapMessage(Throwable error) {
        Throwable current = error;
        while (current instanceof CompletionException && current.getCause() != null) {
            current = current.getCause();
        }
        return current.getMessage() == null ? current.getClass().getSimpleName() : current.getMessage();
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println(LocalDateTime.now() + " - Request sent.");

        CompletableFuture<DebtResult> azerisiqFuture = requestProviderAsync("Azerisiq", 2000, 125.40, executor)
                .completeOnTimeout(timeoutResult("Azerisiq"), 3, TimeUnit.SECONDS)
                .exceptionally(error -> errorResult("Azerisiq", error));

        CompletableFuture<DebtResult> azersuFuture = requestProviderAsync("Azersu", 1000, 48.70, executor)
                .completeOnTimeout(timeoutResult("Azersu"), 3, TimeUnit.SECONDS)
                .exceptionally(error -> errorResult("Azersu", error));

        CompletableFuture<DebtResult> azerqazFuture = requestProviderAsync("Azerqaz", 10000, 89.90, executor)
                .completeOnTimeout(timeoutResult("Azerqaz"), 3, TimeUnit.SECONDS)
                .exceptionally(error -> errorResult("Azerqaz", error));

        CompletableFuture<List<DebtResult>> finalResponseFuture = CompletableFuture
                .allOf(azerisiqFuture, azersuFuture, azerqazFuture)
                .thenApply(ignored -> List.of(
                        azerisiqFuture.join(),
                        azersuFuture.join(),
                        azerqazFuture.join()
                ));

        finalResponseFuture.whenComplete((responses, error) -> {
            System.out.println(LocalDateTime.now() + " - Response received.");
            System.out.println("\n========== FINAL RESPONSE ==========\n");

            if (error != null) {
                System.out.println(DebtResult.of("SYSTEM", null, false, unwrapMessage(error)));
            } else {
                responses.forEach(System.out::println);
            }

            executor.shutdownNow();
        });

        System.out.println(LocalDateTime.now() + " - Main thread blocked deyil, async davam edir.");
    }
}
