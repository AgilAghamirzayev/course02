package az.texnoera.lesson29.dao;

import az.texnoera.lesson29.config.DatabaseConfig;
import az.texnoera.lesson29.entity.Account;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {

    @Override
    public void create(String ownerName, BigDecimal balance) {
        String sql = """
                INSERT INTO accounts (owner_name, balance) 
                VALUES (?, ?)
                """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, ownerName);
            ps.setBigDecimal(2, balance);
            int rowCount = ps.executeUpdate();

            System.out.println(rowCount + " account created");
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Account> findAll() {
        String sql = "SELECT * FROM accounts order by id";

        ArrayList<Account> accountList = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()
        ){

            while (resultSet.next()) {
                Account account = new Account(
                        resultSet.getLong("id"),
                        resultSet.getString("owner_name"),
                        resultSet.getBigDecimal("balance")
                );
                accountList.add(account);
            }
            return accountList;

        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return List.of();
    }

    @Override
    public void updateBalance(Connection connection, Long id, BigDecimal newBalance) {
        String sql = """
                UPDATE accounts 
                SET balance = ? 
                WHERE id = ?
                """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setBigDecimal(1, newBalance);
            ps.setLong(2, id);
            int rowCount = ps.executeUpdate();

            if (rowCount == 0) {
                throw new RuntimeException("Account not found: " + id);
            }

            System.out.println(rowCount + " account updated");
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    @Override
    public BigDecimal getBalance(Connection connection, Long id) {
        try (PreparedStatement ps = connection.prepareStatement("SELECT * from accounts where id =?")) {
            ps.setLong(1, id);
            ResultSet set = ps.executeQuery();

            if (set.next()) {
                return set.getBigDecimal("balance");
            }

            throw new RuntimeException("Account not found: " + id);
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
