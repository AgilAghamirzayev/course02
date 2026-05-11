package l19.fileio.practice1;

public record UserAccount(
        String id,
        String username,
        long createdAtEpochMillis,
        String saltBase64,
        String passwordHashHex
) {
    public UserAccount of(String[] userAccount) {
        return new UserAccount(
                userAccount[0],
                userAccount[1],
                parseLongOrZero(userAccount[2]),
                userAccount[3],
                userAccount[4]
        );
    }

    private static long parseLongOrZero(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}
