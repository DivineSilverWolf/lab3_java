package sapper.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import sapper.core.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sapper.rating.Records;
import sapper.settings.Settings;

public class MenuController implements Initializable {
    @FXML
    private Button settings;
    @FXML
    private Button records;
    @FXML
    private VBox menu;
    @FXML
    private Button startButton;
    private final String SETTING = "Settings";
    private final String RECORDS = "Records";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startButton.setOnAction(actionEvent -> {
            try {
                App.setGame((Stage) menu.getScene().getWindow());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        settings.setOnAction(actionEvent -> {
            try {
                Settings.setRoot(SETTING, settings.getScene());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        records.setOnAction(actionEvent -> {
            try {
                Records.setRoot(RECORDS, records.getScene());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
