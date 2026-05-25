package lesson22.threads.p3;

import java.util.ArrayList;
import java.util.List;

public class ArrayListProblem {

    public static void main(String[] args) {
        List<String> users = new ArrayList<>();

        users.add("Aysu");
        users.add("Ali");
        users.add("Nurlan");

        Thread reader = new Thread(() -> {
            while (true) {
                for (String user : users) {
                    System.out.println("Reading: " + user);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }, "Reader");

        Thread writer = new Thread(() -> {
            int counter = 1;

            while (true) {
                users.add("User-" + counter++);
                System.out.println("Added new user");

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Writer");

        reader.start();
        writer.start();
    }
}