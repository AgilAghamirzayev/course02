package lessoon23.solid.d.g;

public class Main {
    public static void main(String[] args) {
        MySqlUserRepository repository = new MySqlUserRepository();
        UserService service = new UserService(repository);
        service.register("user1");
    }
}
