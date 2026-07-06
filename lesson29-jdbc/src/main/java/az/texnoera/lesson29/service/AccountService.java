package az.texnoera.lesson29.service;

import az.texnoera.lesson29.config.DatabaseConfig;
import az.texnoera.lesson29.dao.AccountDao;
import az.texnoera.lesson29.entity.Account;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AccountService {

    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void createAccount(String ownerName, BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        accountDao.create(ownerName, balance);
    }

    public List<Account> getAllAccounts() {
        return accountDao.findAll();
    }


    public void transferMoney(Long fromOwnerId, Long toOwnerId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        Connection connection = null;

        try {
            connection = DatabaseConfig.getConnection();
            connection.setAutoCommit(false);

            BigDecimal fromBalance = accountDao.getBalance(connection, 1L);
            BigDecimal toBalance = accountDao.getBalance(connection, 2L);

            if (fromBalance.compareTo(amount) < 0) {
                throw new IllegalArgumentException("Insufficient balance");
            }

            BigDecimal newFromBalance = fromBalance.subtract(amount);
            BigDecimal newToBalance = toBalance.add(amount);

            accountDao.updateBalance(connection, 1L, newFromBalance);
            if (true) {
                throw new RuntimeException("Transfer failed");
            }

            accountDao.updateBalance(connection, 2L, newToBalance);

            connection.commit();

            System.out.println("Transfer completed successfully");
        } catch (SQLException e) {
            System.out.println("SQLException bas verdi");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
