package com.green.cinema.controllers;

import com.green.cinema.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {
    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private TitledPane moviePanel;

    @FXML
    private TitledPane staffPanel;

    @FXML
    private MenuItem OptionMenuItem;

    @FXML
    void OptionMenuItemAction(ActionEvent event) {
        viewFactory.showOptionWindow();
    }

    @FXML
    void ViewMenuItemAction(ActionEvent event) {
        viewFactory.showStaffManagementWindow();
    }

    @FXML
    void ViewStaffButtonAction(ActionEvent event) {
        viewFactory.showStaffManagementWindow();
    }

    @FXML
    void OrderMovieButton(ActionEvent event) {

    }

    @FXML
    void ViewMovieButtonAction(ActionEvent event) {
        viewFactory.showMovieManagementWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        moviePanel.setCollapsible(false);
        staffPanel.setCollapsible(false);
    }
}

