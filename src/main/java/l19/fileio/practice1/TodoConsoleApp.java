package l19.fileio.practice1;

import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class TodoConsoleApp {

    private static final Path DATA_DIR = Path.of("data", "practice1");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
                    .withZone(ZoneId.systemDefault());

    private final Scanner scanner = new Scanner(System.in);
    private final AppDataStore dataStore = new AppDataStore(DATA_DIR);
    private final Map<String, UserAccount> usersByNormalizedUsername;
    private final List<TodoItem> todos;

    public TodoConsoleApp() {
        this.usersByNormalizedUsername = dataStore.loadUsersByNormalizedUsername();
        this.todos = new ArrayList<>(dataStore.loadTodos());
    }

    public static void main(String[] args) {
        new TodoConsoleApp().run();
    }

    private void run() {
        printHeader();
        while (true) {
            System.out.println();
            System.out.println("=== Main Menu ===");
            System.out.println("1) Create account");
            System.out.println("2) Login");
            System.out.println("0) Exit");
            int choice = readInt("Choose: ");
            switch (choice) {
                case 1 -> createAccountFlow();
                case 2 -> loginFlow();
                case 0 -> {
                    System.out.println("Goodbye.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void printHeader() {
        System.out.println("==========================================");
        System.out.println(" TODO ");
        System.out.println("==========================================");
        System.out.println("Data directory: " + DATA_DIR.toAbsolutePath());
    }

    private void createAccountFlow() {
        System.out.println();
        System.out.println("--- Create Account ---");
        String username = readNonEmpty("Username: ");
        String normalized = AppDataStore.normalizeUsername(username);
        if (usersByNormalizedUsername.containsKey(normalized)) {
            System.out.println("This username already exists.");
            return;
        }

        String password = readPasswordWithValidation();
        String confirm = readNonEmpty("Confirm password: ");
        if (!password.equals(confirm)) {
            System.out.println("Passwords do not match.");
            return;
        }

        String salt = Passwords.newSaltBase64();
        String hash = Passwords.hash(salt, password);
        UserAccount user = new UserAccount(
                UUID.randomUUID().toString(),
                username.trim(),
                System.currentTimeMillis(),
                salt,
                hash
        );
        usersByNormalizedUsername.put(normalized, user);
        dataStore.saveUsers(usersByNormalizedUsername.values());
        System.out.println("Account created successfully.");
    }

    private void loginFlow() {
        System.out.println();
        System.out.println("--- Login ---");
        String username = readNonEmpty("Username: ");
        UserAccount user = usersByNormalizedUsername.get(AppDataStore.normalizeUsername(username));
        if (user == null) {
            System.out.println("Account not found.");
            return;
        }

        String password = readNonEmpty("Password: ");
        if (!Passwords.matches(user, password)) {
            System.out.println("Invalid password.");
            return;
        }

        System.out.println("Welcome, " + user.username() + ".");
        userSession(user);
    }

    private void userSession(UserAccount user) {
        while (true) {
            List<TodoItem> myTodos = getUserTodos(user.id());
            System.out.println();
            System.out.println("=== TODO Menu (" + user.username() + ") ===");
            System.out.println("1) Show my todos");
            System.out.println("2) Create todo");
            System.out.println("3) Change status");
            System.out.println("4) Delete todo");
            System.out.println("5) Logout");
            System.out.println("0) Exit app");
            System.out.println("My todo count: " + myTodos.size());
            int choice = readInt("Choose: ");

            switch (choice) {
                case 1 -> showTodos(myTodos);
                case 2 -> createTodo(user);
                case 3 -> changeTodoStatus(user);
                case 4 -> deleteTodo(user);
                case 5 -> {
                    System.out.println("Logged out.");
                    return;
                }
                case 0 -> {
                    System.out.println("Goodbye.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void showTodos(List<TodoItem> todosForUser) {
        System.out.println();
        System.out.println("--- My Todos ---");
        if (todosForUser.isEmpty()) {
            System.out.println("No todos yet.");
            return;
        }
        for (int i = 0; i < todosForUser.size(); i++) {
            TodoItem item = todosForUser.get(i);
            System.out.printf(
                    "%d) [%s] %s | created: %s | updated: %s%n",
                    i + 1,
                    item.status(),
                    item.title(),
                    formatTime(item.createdAtEpochMillis()),
                    formatTime(item.updatedAtEpochMillis())
            );
        }
    }

    private void createTodo(UserAccount user) {
        System.out.println();
        System.out.println("--- Create Todo ---");
        String title = readNonEmpty("Todo title: ");
        long now = System.currentTimeMillis();
        TodoItem item = new TodoItem(
                UUID.randomUUID().toString(),
                user.id(),
                title,
                TodoStatus.TODO,
                now,
                now
        );
        todos.add(item);
        dataStore.saveTodos(todos);
        System.out.println("Todo created.");
    }

    private void changeTodoStatus(UserAccount user) {
        List<TodoItem> myTodos = getUserTodos(user.id());
        if (myTodos.isEmpty()) {
            System.out.println("You do not have todos to update.");
            return;
        }

        showTodos(myTodos);
        int todoNumber = readInt("Choose todo number: ");
        if (todoNumber < 1 || todoNumber > myTodos.size()) {
            System.out.println("Invalid todo number.");
            return;
        }
        TodoItem selected = myTodos.get(todoNumber - 1);
        TodoStatus newStatus = readStatus();
        if (selected.status() == newStatus) {
            System.out.println("Todo already has this status.");
            return;
        }

        TodoItem updated = new TodoItem(
                selected.id(),
                selected.userId(),
                selected.title(),
                newStatus,
                selected.createdAtEpochMillis(),
                System.currentTimeMillis()
        );
        replaceTodoById(updated);
        dataStore.saveTodos(todos);
        System.out.println("Todo status updated.");
    }

    private void deleteTodo(UserAccount user) {
        List<TodoItem> myTodos = getUserTodos(user.id());
        if (myTodos.isEmpty()) {
            System.out.println("You do not have todos to delete.");
            return;
        }

        showTodos(myTodos);
        int todoNumber = readInt("Choose todo number to delete: ");
        if (todoNumber < 1 || todoNumber > myTodos.size()) {
            System.out.println("Invalid todo number.");
            return;
        }

        TodoItem selected = myTodos.get(todoNumber - 1);
        String confirm = readNonEmpty("Type YES to confirm deletion: ");
        if (!"YES".equals(confirm)) {
            System.out.println("Delete canceled.");
            return;
        }

        todos.removeIf(t -> t.id().equals(selected.id()) && t.userId().equals(user.id()));
        dataStore.saveTodos(todos);
        System.out.println("Todo deleted.");
    }

    private TodoStatus readStatus() {
        while (true) {
            System.out.println("Select new status:");
            System.out.println("1) TODO");
            System.out.println("2) IN_PROGRESS");
            System.out.println("3) DONE");
            int statusChoice = readInt("Choose: ");
            switch (statusChoice) {
                case 1 -> {
                    return TodoStatus.TODO;
                }
                case 2 -> {
                    return TodoStatus.IN_PROGRESS;
                }
                case 3 -> {
                    return TodoStatus.DONE;
                }
                default -> System.out.println("Invalid status choice.");
            }
        }
    }

    private List<TodoItem> getUserTodos(String userId) {
        return todos.stream()
                .filter(t -> t.userId().equals(userId))
                .sorted(Comparator.comparingLong(TodoItem::createdAtEpochMillis))
                .toList();
    }

    private void replaceTodoById(TodoItem updated) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).id().equals(updated.id())) {
                todos.set(i, updated);
                return;
            }
        }
    }

    private String formatTime(long epochMillis) {
        return TIME_FORMATTER.format(Instant.ofEpochMilli(epochMillis));
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    private String readPasswordWithValidation() {
        while (true) {
            String password = readNonEmpty("Password (min 6 chars): ");
            if (password.length() < 6) {
                System.out.println("Password must be at least 6 characters.");
                continue;
            }
            return password;
        }
    }
}
