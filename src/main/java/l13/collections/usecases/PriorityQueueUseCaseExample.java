package l13.collections.usecases;

import java.util.PriorityQueue;

public class PriorityQueueUseCaseExample {
    public static void main(String[] args) {
        // Real use case: emergency room where critical patient is handled first.
        PriorityQueue<Patient> patients = new PriorityQueue<>();
        patients.offer(new Patient("Patient A", 3));
        patients.offer(new Patient("Patient B", 1));
        patients.offer(new Patient("Patient C", 2));

        System.out.println("Where to use PriorityQueue: process by priority, not arrival order.");
        while (!patients.isEmpty()) {
            System.out.println("Treat now: " + patients.poll());
        }
    }

    static class Patient implements Comparable<Patient> {
        String name;
        int priority; // 1 is highest priority

        Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public int compareTo(Patient other) {
            return Integer.compare(this.priority, other.priority);
        }

        @Override
        public String toString() {
            return name + "(priority=" + priority + ")";
        }
    }
}
