package lesson22.threads.p5.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class S2CallableWithExecutor {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<String> paymentTask = () -> {
            System.out.println(Thread.currentThread().getName() + " processing payment...");
            Thread.sleep(3000);
            return "TXN-948293";
        };

        Future<String> future = executor.submit(paymentTask);

        Thread.sleep(1000);
        System.out.println("Doing other work...");

        String transactionId = future.get();

        System.out.println("Transaction completed: " + transactionId);

        executor.shutdown();

    }
}