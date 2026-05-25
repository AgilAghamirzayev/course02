package l21.threads1.p1;

public class Test5 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 is running");
            }
        });
        thread1.start();
        thread1.start();
    }

}