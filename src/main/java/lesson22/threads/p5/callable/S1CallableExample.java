package lesson22.threads.p5.callable;

import java.util.concurrent.Callable;

public class S1CallableExample {

    public static void main(String[] args) throws Exception {

        Callable<String> task = () -> {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " processing payment...");
            return "Payment Success";
        };

        String result = task.call();

        System.out.println(result);
    }
}