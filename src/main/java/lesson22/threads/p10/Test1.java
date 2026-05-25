package lesson22.threads.p10;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i <= 6000000; i++) {
            int finalI = i;
            Thread.startVirtualThread(() -> System.out.println( finalI + "Virtual thread is running")).join();

            System.out.println("Main thread is waiting...");

        }

    }


}
