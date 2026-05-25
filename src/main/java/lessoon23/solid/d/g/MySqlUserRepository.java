package lessoon23.solid.d.g;

class MySqlUserRepository implements UserRepository {
    public void save(String username) {
        System.out.println("Saving user to MySQL: " + username);
    }
}
