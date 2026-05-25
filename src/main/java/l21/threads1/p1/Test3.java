package l21.threads1.p1;



public class Test3 {

    public static void main(String[] args) {

        ChefThread chefThread = new ChefThread();
        chefThread.setName("Chief Thread");
        chefThread.start();

        System.out.println(Thread.currentThread().getName() + " is taking orders...");
    }
}