package sapper.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sapper.models.RecordsModel;
import sapper.models.SettingLevelModel;

import java.net.URL;
import java.util.ResourceBundle;

public class RecordsController implements Initializable {
    @FXML
    private RadioButton lvlNumber1;
    @FXML
    private ToggleGroup levels;
    @FXML
    private RadioButton lvlNumber2;
    @FXML
    private RadioButton lvlNumber3;
    @FXML
    private TextField rec1;
    @FXML
    private TextField rec2;
    @FXML
    private TextField rec3;
    @FXML
    private TextField rec4;
    @FXML
    private TextField rec5;
    @FXML
    private TextField rec6;
    @FXML
    private TextField rec7;
    @FXML
    private TextField rec8;
    @FXML
    private TextField rec9;
    @FXML
    private TextField rec10;

    @FXML
    private Button menu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextField[] textFields = initTextFieldArray();


        MenuButtonController.goMenu(menu);
        levels.selectedToggleProperty().addListener((changed, oldValue, newValue) ->
        {
            RadioButton button = (RadioButton) newValue;
            RecordsModel.readFile(textFields, button.getText());
        });
    }

    private final int SIZE_REC = 10;

    private TextField[] initTextFieldArray() {
        TextField[] load = new TextField[SIZE_REC];
        load[0] = rec1;
        load[1] = rec2;
        load[2] = rec3;
        load[3] = rec4;
        load[4] = rec5;
        load[5] = rec6;
        load[6] = rec7;
        load[7] = rec8;
        load[8] = rec9;
        load[9] = rec10;
        return load;
    }
}
