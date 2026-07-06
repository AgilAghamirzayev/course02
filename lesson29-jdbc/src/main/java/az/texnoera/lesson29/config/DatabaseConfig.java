package az.texnoera.lesson29.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL = "jdbc:postgresql://localhost:8889/bankdb";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public static Connection getConnection()  {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println( "Connection failed! Check output console" + e);
            throw new RuntimeException(e);
        }
    }

}
