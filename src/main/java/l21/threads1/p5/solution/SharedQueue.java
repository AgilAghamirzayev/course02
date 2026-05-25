package l21.threads1.p5.solution;

import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException {

        while (queue.size() == capacity) {
            System.out.println("Queue full. Producer waiting...");
            wait();
        }

        queue.add(value);
        System.out.println("Produced: " + value + " | Queue: " + queue);

        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {

        while (queue.isEmpty()) {
            System.out.println("Queue empty. Consumer waiting...");
            wait();
        }

        int value = queue.poll();
        System.out.println("Consumed: " + value + " | Queue: " + queue);

        notifyAll();

        return value;
    }
}