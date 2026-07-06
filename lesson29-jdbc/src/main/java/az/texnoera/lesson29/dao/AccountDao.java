package az.texnoera.lesson29.dao;

import az.texnoera.lesson29.entity.Account;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface AccountDao {
    void create(String ownerName, BigDecimal balance);
    Optional<Account> findById(Long id);
    List<Account> findAll();
    void updateBalance(Connection connection,  Long id, BigDecimal newBalance);
    BigDecimal getBalance(Connection connection, Long id);
}
