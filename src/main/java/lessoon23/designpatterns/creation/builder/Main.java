package lessoon23.designpatterns.creation.builder;

public class Main {
    public static void main(String[] args) {
        User user = User.builder()
                .firstName("Ali")
                .lastName("Mammadov")
                .email("ali@example.com")
                .age(25)
                .build();

        System.out.println(user);
    }
}
