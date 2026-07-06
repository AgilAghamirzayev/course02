package lesson23.solid.d.b;

class UserService {
    private MySqlUserRepository repository = new MySqlUserRepository();

    public void register(String username) {
        repository.save(username);
    }
}