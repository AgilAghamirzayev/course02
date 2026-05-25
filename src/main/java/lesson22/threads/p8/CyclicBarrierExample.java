package lesson22.threads.p8;

import java.util.concurrent.CyclicBarrier;

// “Hamı checkpoint-ə çatmadan heç kim davam etməsin.”
public class CyclicBarrierExample {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3);

        Runnable task = () -> {

            try {

                System.out.println(Thread.currentThread().getName() + " preparing...");
                Thread.sleep((long) (Math.random() * 5000));

                System.out.println(Thread.currentThread().getName() + " waiting at barrier...");

                barrier.await();

                System.out.println(Thread.currentThread().getName() + " passed barrier!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(task, "Player-1").start();
        new Thread(task, "Player-2").start();
        new Thread(task, "Player-3").start();
    }
}