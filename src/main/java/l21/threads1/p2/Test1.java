package l21.threads1.p2;

public class Test1 {

    public static void main(String[] args) {
        Worker t1 = new Worker("Payment-Service");
        Worker t2 = new Worker("Notification-Service");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}