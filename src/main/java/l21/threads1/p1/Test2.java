package l21.threads1.p1;



public class Test2 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 is running...");
            }
        });


        thread.start();
        System.out.println("Main Thread is running...");
    }
}