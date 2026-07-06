package lesson23.solid.d.g;

public class Main {
    public static void main(String[] args) {
        UserRepository repository = new PostgreSqlUserRepository();
        UserService service = new UserService(repository);
        service.register("user1");
    }
}
