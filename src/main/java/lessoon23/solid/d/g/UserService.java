package lessoon23.solid.d.g;

class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void register(String username) {
        repository.save(username);
    }
}