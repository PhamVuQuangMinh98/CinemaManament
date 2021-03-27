package com.green.cinema.controllers;

import com.green.cinema.dbdao.UserDao;
import com.green.cinema.model.User;
import com.green.cinema.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaffManagementWindowController extends BaseController implements Initializable {
    public StaffManagementWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }
    ArrayList<User> users = new ArrayList<>();
    UserDao userDao = new UserDao();

    @FXML
    private TableView<User> staffTable;

    @FXML
    private TableColumn<User, Integer> userIdColumn;

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private Button closeButton;

    @FXML
    void closeButtonAction(ActionEvent event) {
        closeStage();
    }
    private  void closeStage(){
        Stage stage = (Stage) staffTable.getScene().getWindow();
        viewFactory.closeStage(stage);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
    }

    public void initTable(){
        userIdColumn = new TableColumn<>("UserID");
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("UserID"));
        emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));

        ObservableList<User> list = FXCollections.observableList(userDao.GetUser(viewFactory.getDbConnector().getDBConnection()));
        list.addAll(userDao.GetUser(viewFactory.getDbConnector().getDBConnection()));
        staffTable.setItems(list);

//        users = userDao.GetUser(viewFactory.getDbConnector().getDBConnection());
//        for(User user: users){
//            staffTable.getItems().add(user);
//        }
    }
}
