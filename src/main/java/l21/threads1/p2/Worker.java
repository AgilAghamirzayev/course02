package l21.threads1.p2;

public class Worker extends Thread {

    public Worker(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread: " + getName() + " Priority: " + getPriority());
    }
}