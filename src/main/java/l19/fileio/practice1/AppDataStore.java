package l19.fileio.practice1;

import static l19.fileio.practice1.FileUtils.readAll;
import static l19.fileio.practice1.FileUtils.writeAtomically;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class AppDataStore {

    private static final String USERS_FILE = "users.db";
    private static final String TODOS_FILE = "todos.db";

    private final Path usersPath;
    private final Path todosPath;

    public AppDataStore(Path dataDir) {
        this.usersPath = dataDir.resolve(USERS_FILE);
        this.todosPath = dataDir.resolve(TODOS_FILE);
        initFiles();
    }

    private void initFiles() {
        try {
            if (usersPath.getParent() != null) {
                Files.createDirectories(usersPath.getParent());
            }
            if (Files.notExists(usersPath)) {
                Files.createFile(usersPath);
            }
            if (Files.notExists(todosPath)) {
                Files.createFile(todosPath);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Could not initialize storage files", e);
        }
    }

    public Map<String, UserAccount> loadUsersByNormalizedUsername() {
        Map<String, UserAccount> users = new HashMap<>();
        List<String> lines = readAll(usersPath);
        for (String line : lines) {
            if (line.isBlank()) {
                continue;
            }
            String[] p = line.split("\t", -1);
            if (p.length != 5) {
                continue;
            }
            UserAccount user = new UserAccount(
                    p[0],
                    p[1],
                    parseLongOrZero(p[2]),
                    p[3],
                    p[4]
            );
            users.put(normalizeUsername(user.username()), user);
        }
        return users;
    }

//    public Map<String, UserAccount> loadUsersByNormalizedUsername() {
//        return readAll(usersPath).stream()
//                .filter(line -> !line.isBlank())
//                .map(line -> line.split("\t", -1))
//                .filter(parts -> parts.length == 5)
//                .map(parts -> new UserAccount(
//                        parts[0],
//                        parts[1],
//                        parseLongOrZero(parts[2]),
//                        parts[3],
//                        parts[4]
//                ))
//                .collect(Collectors.toMap(
//                        user -> normalizeUsername(user.username()),
//                        Function.identity()
//                ));
//    }

    public List<TodoItem> loadTodos() {
        List<TodoItem> todos = new ArrayList<>();
        List<String> lines = readAll(todosPath);
        for (String line : lines) {
            if (line.isBlank()) {
                continue;
            }
            String[] p = line.split("\t", -1);
            if (p.length != 6) {
                continue;
            }
            try {
                TodoItem item = new TodoItem(
                        p[0],
                        p[1],
                        decodeBase64(p[2]),
                        TodoStatus.valueOf(p[3]),
                        parseLongOrZero(p[4]),
                        parseLongOrZero(p[5])
                );
                todos.add(item);
            } catch (IllegalArgumentException ignored) {
                System.out.println("Cannot parse");
            }
        }
        return todos;
    }

    public void saveUsers(Collection<UserAccount> users) {
        List<String> lines = new ArrayList<>();
        for (UserAccount account : users) {
            lines.add(String.join("\t",
                    account.id(),
                    account.username(),
                    Long.toString(account.createdAtEpochMillis()),
                    account.saltBase64(),
                    account.passwordHashHex()
            ));
        }
        writeAtomically(usersPath, lines);
    }

//    public void saveUsers(Collection<UserAccount> users) {
//        List<String> lines = users.stream()
//                .map(account -> String.join("\t",
//                        account.id(),
//                        account.username(),
//                        Long.toString(account.createdAtEpochMillis()),
//                        account.saltBase64(),
//                        account.passwordHashHex()
//                ))
//                .toList();
//
//        writeAtomically(usersPath, lines);
//    }
//

    public void saveTodos(Collection<TodoItem> todos) {
        List<String> lines = new ArrayList<>();
        for (TodoItem item : todos) {
            lines.add(String.join("\t",
                    item.id(),
                    item.userId(),
                    encodeBase64(item.title()),
                    item.status().name(),
                    Long.toString(item.createdAtEpochMillis()),
                    Long.toString(item.updatedAtEpochMillis())
            ));
        }
        writeAtomically(todosPath, lines);
    }

    public static String normalizeUsername(String username) {
        return username.trim().toLowerCase();
    }

    private static long parseLongOrZero(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    private static String encodeBase64(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    private static String decodeBase64(String value) {
        return new String(Base64.getDecoder().decode(value), StandardCharsets.UTF_8);
    }
}
