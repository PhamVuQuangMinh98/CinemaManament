package com.green.cinema.controllers;

import com.green.cinema.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MainWindowController extends BaseController {
    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private MenuItem OptionMenuItem;

    @FXML
    void OptionMenuItemAction(ActionEvent event) {
        viewFactory.showOptionWindow();
    }
    @FXML
    private MenuItem ViewMenuItem;

    @FXML
    void ViewMenuItemAction(ActionEvent event) {
        viewFactory.showStaffManagementWindow();
    }
}
