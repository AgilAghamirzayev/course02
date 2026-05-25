package l21.threads1.p5.problem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {

    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 5;

    public void produce(int value) {
        if (queue.size() == capacity) {
            System.out.println("Queue full, producer skips: " + value + " | Queue: " + queue);
            return;
        }

        queue.add(value);
        System.out.println("Produced: " + value + " | Queue: " + queue);
    }

    public void consume() {
        if (queue.isEmpty()) {
            System.out.println("Queue empty, consumer skips | Queue: " + queue);
            return;
        }

        Integer value = queue.poll();
        System.out.println("Consumed: " + value + " | Queue: " + queue);
    }
    
}
