package com.green.cinema.view;

import com.green.cinema.controllers.*;
import com.green.cinema.dbconnector.DBConnector;
import com.green.cinema.emum.ColorTheme;
import com.green.cinema.emum.FontSize;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    private FontSize fontSize = FontSize.SMALL;
    private ColorTheme colorTheme = ColorTheme.DEFAULT;

    private DBConnector dbConnector;

    public DBConnector getDbConnector() {
        return dbConnector;
    }

    public ViewFactory(DBConnector dbConnector){
        this.dbConnector = dbConnector;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public void showLoginWindow(){
        System.out.println("Show login window");
        BaseController controller = new LoginWindowController(this, "Login.fxml");
        initializeStage(controller);
    }

    public void showMainWindow(){
        System.out.println("Show main window");
        BaseController controller = new MainWindowController(this, "MainWindow.fxml");
        initializeStage(controller);
    }

    public void showOptionWindow(){
        System.out.println("Show Option window");
        BaseController controller = new OptionWindowController(this, "OptionWindow.fxml");
        initializeStage(controller, true);
    }

    public void showStaffManagementWindow(){
        System.out.println("Show Staff Management window");
        BaseController controller = new StaffManagementWindowController(this, "StaffManagementWindow.fxml");
        initializeStage(controller, true);
    }

    public void closeStage(Stage stage){
        stage.close();
    }

    private void initializeStage(BaseController controller){
        initializeStage(controller, false);
    }

    private void initializeStage(BaseController controller, boolean isModal){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);

        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            System.out.println("initializeStage: failed to load fxml");
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        if(isModal){
            stage.initModality(Modality.APPLICATION_MODAL);
        }

        stage.setScene(scene);
        stage.show();
    }
}
