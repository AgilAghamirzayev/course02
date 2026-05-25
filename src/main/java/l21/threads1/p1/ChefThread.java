package l21.threads1.p1;

public class ChefThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is cooking...");
    }

}