package org.example.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static String dbUrl = "jdbc:h2:~/test";
    private static String userName = "sa";
    private static String password = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, userName, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return connection;

    }
}
