package l13.collections.usecases;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUseCaseExample {
    public static void main(String[] args) {
        // Real use case: students waiting for library service.
        Queue<String> libraryQueue = new LinkedList<>();
        libraryQueue.offer("Aysel");
        libraryQueue.offer("Orkhan");
        libraryQueue.offer("Nigar");

        String servedStudent = libraryQueue.poll();

        System.out.println("Where to use Queue: FIFO waiting lines.");
        System.out.println("Served: " + servedStudent);
        System.out.println("Remaining queue: " + libraryQueue);
    }
}
