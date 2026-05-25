package l21.threads1.p1;


public class Test4 {

    public static void main(String[] args) {

        Thread deliveryThread = new Thread(new DeliveryTask());

        deliveryThread.start();

        System.out.println("Application still running...");
    }
}