package com.green.cinema.dbdao;

import com.green.cinema.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {

    private final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS USER"
            +"(USER_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            " EMAIL VARCHAR(64)," +
            " PASSWORD VARCHAR(64));";

    private final String CREATE_INIT_USER = "INSERT INTO USER (EMAIL, PASSWORD)" +
            " VALUES('quangminh', '123456');";

    private  final String GET_USER = "SELECT * FROM USER;";

    private final String FIND_USER = "SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ?;";

    private  final String DROP_TABLE_USER = "DROP TABLE IF EXISTS USER;";

    public UserDao(){

    }

    public int createTableUser(Connection connection){
        int result = 0;
        Statement statement = null;
        try {
            statement = connection.createStatement();

            statement.executeUpdate(DROP_TABLE_USER);
            statement.executeUpdate(CREATE_TABLE_USER);

            System.out.println("Table user created");
        }catch (SQLException ex){
            result = -1;
            System.out.println("Table created fail: "+ex.getMessage());
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    }

    public int createInitUser(Connection connection){
        int result = 0;
        Statement statement = null;
        try {
            statement = connection.createStatement();

            statement.executeUpdate(CREATE_INIT_USER);

            System.out.println("Table user created");
        }catch (SQLException ex){
            result = -1;
            System.out.println("Table created fail: "+ex.getMessage());
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    }

    public User FindUser(Connection connection, String email, String password){
        User user = new User();
        PreparedStatement preparedStatement =null;

        try {
            preparedStatement = connection.prepareStatement(FIND_USER);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setUserId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public ArrayList<User> GetUser(Connection connection){
        ArrayList<User> users = new ArrayList<>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_USER);
            while (resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                //user.setPassword(resultSet.getString(3));
                users.add(user);
            }
        }catch (SQLException ex){
            System.out.println("Data Show fail: "+ex.getMessage());
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return users;
    }
}
