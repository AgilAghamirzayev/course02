package l13.collections.usecases;

import java.util.Stack;

public class StackUseCaseExample {
    public static void main(String[] args) {
        // Real use case: undo feature in a drawing app.
        Stack<String> undoHistory = new Stack<>();
        undoHistory.push("Draw circle");
        undoHistory.push("Color circle blue");
        undoHistory.push("Add smile");

        String lastAction = undoHistory.pop();

        System.out.println("Where to use Stack: LIFO operations like Undo.");
        System.out.println("Removed last action: " + lastAction);
        System.out.println("Current history: " + undoHistory);
    }
}
