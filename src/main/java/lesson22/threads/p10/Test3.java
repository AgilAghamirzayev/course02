package lesson22.threads.p10;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i <= 6000000; i++) {
            int finalI = i;

//            new Thread(() -> System.out.println( finalI + "Thread is running"));
            Thread.startVirtualThread(() -> System.out.println( finalI + "Virtual thread is running"));
            
            System.out.println("Main thread is waiting...");

        }

    }


}
