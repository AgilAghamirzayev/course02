package lesson22.threads.p4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            executorService.submit(() -> {

                    System.out.println(Thread.currentThread().getName() + " processing task " + taskId);

                    doTask();

                    System.out.println(Thread.currentThread().getName() + " completed task " + taskId);

            });
        }

        executorService.shutdown();
    }

    private static void doTask() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}