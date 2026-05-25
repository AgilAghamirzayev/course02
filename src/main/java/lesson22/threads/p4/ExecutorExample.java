package lesson22.threads.p4;

import java.util.concurrent.Executor;

public class ExecutorExample {

    static class SimpleExecutor implements Executor {
        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }

    public static void main(String[] args) {

        Executor executor = new SimpleExecutor();

        executor.execute(() -> System.out.println(Thread.currentThread().getName() + " executing task"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName() + " executing another task"));
    }
}