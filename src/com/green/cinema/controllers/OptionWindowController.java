package com.green.cinema.controllers;

import com.green.cinema.emum.ColorTheme;
import com.green.cinema.emum.FontSize;
import com.green.cinema.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionWindowController extends BaseController implements Initializable {
    public OptionWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private ChoiceBox<ColorTheme> colorThemeCbox;

    @FXML
    private Slider fontSizeSlider;

    @FXML
    private Button applyButton;

    @FXML
    private Button cancelButton;

    @FXML
    void applyButtonAction(ActionEvent event) {
        closeStage();
    }

    @FXML
    void cancelButtonAction(ActionEvent event) {
        closeStage();
    }

    private  void closeStage(){
        Stage stage = (Stage) applyButton.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initChoiceBoxTheme();
        initSliderFontSize();
    }

    private void initSliderFontSize(){
        fontSizeSlider.setMin(0);
        fontSizeSlider.setMax(FontSize.values().length-1);
        fontSizeSlider.setValue(viewFactory.getFontSize().ordinal());
        fontSizeSlider.setMajorTickUnit(1);
        fontSizeSlider.setMinorTickCount(0);
        fontSizeSlider.setBlockIncrement(1);
        fontSizeSlider.setSnapToTicks(true);
        fontSizeSlider.setShowTickLabels(true);
        fontSizeSlider.setShowTickMarks(true);
        fontSizeSlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                int i = aDouble.intValue();
                return FontSize.values()[i].toString();
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });
    }

    private void initChoiceBoxTheme(){
        colorThemeCbox.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        colorThemeCbox.setValue(viewFactory.getColorTheme());
    }
}
