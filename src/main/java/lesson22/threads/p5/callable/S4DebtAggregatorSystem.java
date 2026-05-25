package lesson22.threads.p5.callable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class S4DebtAggregatorSystem {

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

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<DebtResult> azerisiqTask = () -> {
            Thread.sleep(2000);
            return DebtResult.of("Azərişıq", 125.40, true, "Success");
        };

        Callable<DebtResult> azersuTask = () -> {
            Thread.sleep(1000);
            return DebtResult.of("Azərsu", 48.70, true, "Success");
        };

        Callable<DebtResult> azerqazTask = () -> {
            Thread.sleep(10000);
            return DebtResult.of("Azərqaz", 89.90, true, "Success");
        };

        List<Callable<DebtResult>> tasks = List.of(azerisiqTask, azersuTask, azerqazTask);
        List<String> providers = List.of("Azərişıq", "Azərsu", "Azərqaz");

        List<DebtResult> responses = new ArrayList<>();

        System.out.println(LocalDateTime.now() + " - Request sent.");
        try {
            List<Future<DebtResult>> futures = executor.invokeAll(tasks, 3, TimeUnit.SECONDS);

            for (int i = 0; i < futures.size(); i++) {
                Future<DebtResult> future = futures.get(i);
                String provider = providers.get(i);

                if (future.isCancelled()) {
                    responses.add(DebtResult.of(provider, null, false, "Provider timeout"));
                    continue;
                }

                try {
                    responses.add(future.get());
                } catch (Exception e) {
                    responses.add(DebtResult.of(provider, null, false, e.getMessage()));
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            responses.add(DebtResult.of("SYSTEM", null, false, "Interrupted while waiting for providers"));
        }

        System.out.println(LocalDateTime.now() + " - Response received.");
        System.out.println("\n========== FINAL RESPONSE ==========\n");

        for (DebtResult response : responses) {
            System.out.println(response);
        }

        executor.shutdown();
    }
}
