package lesson22.threads.p8;

import java.util.concurrent.CyclicBarrier;

public class GameRounds {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3);

        Runnable player = () -> {

            try {

                for (int round = 1; round <= 3; round++) {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " playing round "
                                    + round
                    );

                    Thread.sleep((long) (Math.random() * 3000));

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " waiting others..."
                    );

                    barrier.await();

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " starting next round"
                    );
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(player, "Player-1").start();
        new Thread(player, "Player-2").start();
        new Thread(player, "Player-3").start();
    }
}