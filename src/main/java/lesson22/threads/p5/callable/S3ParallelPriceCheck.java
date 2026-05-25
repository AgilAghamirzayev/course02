package lesson22.threads.p5.callable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class S3ParallelPriceCheck {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<PriceResult> amazon = () -> {
            Thread.sleep(2000);
            return new PriceResult("Amazon", 120);
        };

        Callable<PriceResult> trendyol = () -> {
            Thread.sleep(1000);
            return new PriceResult("Trendyol", 115);
        };

        Callable<PriceResult> temu = () -> {
            Thread.sleep(3000);
            return new PriceResult("Temu", 110);
        };

        List<Callable<PriceResult>> tasks = Arrays.asList(amazon, trendyol, temu);

        System.out.println(LocalDateTime.now() + " Starting tasks: " + tasks.size());

        List<Future<PriceResult>> futures = executor.invokeAll(tasks);
        System.out.println(LocalDateTime.now() + " Finished tasks: " + futures.size());

        for (Future<PriceResult> future : futures) {
            PriceResult result = future.get();
            System.out.println(result);
        }

        executor.shutdown();
    }
}