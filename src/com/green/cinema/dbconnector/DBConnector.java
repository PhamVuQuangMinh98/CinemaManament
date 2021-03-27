package com.green.cinema.dbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost/cinema?user=approot&password=123456";

    public DBConnector(){}

    public Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_CONNECTION);
            System.out.println("Get db connection success");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load db driver");
        } catch (SQLException throwables) {
            System.out.println("Make connection ex: " + throwables.getMessage());
        }

        return connection;
    }
}
