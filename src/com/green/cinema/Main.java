package com.green.cinema;

import com.green.cinema.dbconnector.DBConnector;
import com.green.cinema.dbdao.UserDao;
import com.green.cinema.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Connection connection = new DBConnector().getDBConnection();
        UserDao userDao = new UserDao();

        userDao.createTableUser(connection);
        userDao.createInitUser(connection);

        ViewFactory viewFactory = new ViewFactory(new DBConnector());
        //viewFactory.showLoginWindow();
        viewFactory.showMainWindow();
    }
}
