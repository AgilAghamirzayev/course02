package l21.threads1.p2;

import java.time.Duration;

public class Test2 {

    // 1-> getAzersuBalance()
    // 2-> getAzerIsiqBalance()
    // 1-> getAzerQazBalance()
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        Thread azerSu = new Thread(Test2::getAzersuBalance);
        Thread azerIsiq = new Thread(Test2::getAzerIsiqBalance);
        Thread azerQaz = new Thread(Test2::getAzerQazBalance);

        azerSu.setName("Azersu");
        azerIsiq.setName("AzerIsiq");
        azerQaz.setName("AzerQaz");

        azerSu.start();
        azerIsiq.start();
        azerQaz.start();

        try {
            azerSu.join();
            azerIsiq.join();
            azerQaz.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " main thread is waiting...");
        System.out.println("Duration: " + ((System.currentTimeMillis() - l)/1000) + " seconds" );
    }

    private static void getAzersuBalance() {
        System.out.println(Thread.currentThread().getName() + " balance: 10");
        sleep(Duration.ofSeconds(1));
    }

    private static void getAzerIsiqBalance() {
        System.out.println(Thread.currentThread().getName() + " balance: 20");
        sleep(Duration.ofSeconds(2));
    }

    private static void getAzerQazBalance() {
        System.out.println(Thread.currentThread().getName() + " balance: 30");
        sleep(Duration.ofSeconds(3));
    }

    private static void sleep(Duration duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}