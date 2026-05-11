package l16.examandrecord;

public class RecordDemo02Validation {

    public record User(String username, String email, int age) {
        public User {
            if (username == null || username.isBlank()) {
                throw new IllegalArgumentException("username bos ola bilmez");
            }
            if (email == null || !email.contains("@")) {
                throw new IllegalArgumentException("email formati yanlisdir");
            }
            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("yas araliqdan kenardadir");
            }
        }
    }

    public static void main(String[] args) {
        User ok = new User("murad", "murad@example.com", 21);
        System.out.println("Valid user: " + ok);

        try {
            new User("", "bad-mail", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation xetasi: " + e.getMessage());
        }
    }
}

