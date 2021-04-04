package com.green.cinema.controllers;

import com.green.cinema.dbconnector.DBConnector;
import com.green.cinema.dbdao.UserDao;
import com.green.cinema.model.User;
import com.green.cinema.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.ArrayList;

public class LoginWindowController extends BaseController {
    Connection connection = new DBConnector().getDBConnection();
    UserDao userDao = new UserDao();
    User user = null;
    @FXML
    private Label emailLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    public LoginWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction(ActionEvent event) {
        boolean loginSuccess = false;
        if(!"".equals(emailTextField.getText()) || !"".equals(emailTextField.getText())){
            user = userDao.FindUser(connection, emailTextField.getText(), passwordField.getText());

            if(user.getUserId() != 0 && user.getEmail().equals(emailTextField.getText()) && user.getPassword().equals(passwordField.getText())){
                loginSuccess = true;
            }
        }

        if(loginSuccess){
            viewFactory.showMainWindow();
            Stage stage = (Stage) errorLabel.getScene().getWindow();
            viewFactory.closeStage(stage);
        }
        else {
            errorLabel.setText("Email or Password incorrect");
        }
    }
}
