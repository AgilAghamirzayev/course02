package l13.collections.usecases;

import java.util.Deque;
import java.util.LinkedList;

public class DequeUseCaseExample {
    public static void main(String[] args) {
        // Real use case: train wagons can be attached from both sides.
        Deque<String> wagons = new LinkedList<>();
        wagons.addFirst("Engine");
        wagons.addLast("Food Wagon");
        wagons.addLast("Passenger Wagon");
        wagons.addFirst("New Engine");

        System.out.println("Where to use Deque: add/remove from both ends.");
        System.out.println("Train: " + wagons);
    }
}
