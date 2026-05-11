package l19.fileio.practice1;

public record TodoItem(
        String id,
        String userId,
        String title,
        TodoStatus status,
        long createdAtEpochMillis,
        long updatedAtEpochMillis
) {
}
