package sapper.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import sapper.contexts.ContextSetting;
import sapper.models.SettingLevelModel;
import sapper.models.SettingStringsModels;
import sapper.models.WriterToFile;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class SettingsController implements Initializable {
    @FXML
    private Button standardSetting;
    @FXML
    private Button currentSetting;
    @FXML
    private Button menu;
    @FXML
    private Button save;
    @FXML
    private TextField stageSizeX;
    @FXML
    private TextField stageSizeY;
    @FXML
    private TextField Xn;
    @FXML
    private TextField Yn;
    @FXML
    private TextField sizeMines;
    @FXML
    private TextField sizeCell;
    @FXML
    private TextField sizeAttempts;
    @FXML
    private TextField nameUser;
    @FXML
    private RadioButton lvlNumber1;
    @FXML
    private ToggleGroup levels;
    @FXML
    private RadioButton lvlNumber2;
    @FXML
    private RadioButton lvlNumber3;
    @FXML
    private RadioButton lvlNumberCustom;
    @FXML
    private Text errorSizeStage;
    @FXML
    private Text errorSizeCell;
    @FXML
    private Text errorSizeMines;
    @FXML
    private Text errorSizeAttempts;
    private static final boolean ALLOW_INPUT = true;
    private static final boolean DISABLE_INPUT = false;
    private static final boolean DEFAULT_FLAG = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AtomicBoolean flagStage = new AtomicBoolean(DEFAULT_FLAG);
        AtomicBoolean flagCellSize = new AtomicBoolean(DEFAULT_FLAG);
        AtomicBoolean flagMinesSize = new AtomicBoolean(DEFAULT_FLAG);
        AtomicBoolean flagAttempts = new AtomicBoolean(DEFAULT_FLAG);
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        AtomicReference<String> levelID = new AtomicReference<>(lvlNumberCustom.getText());
        ContextSetting contextSetting = new ContextSetting(save, stageSizeX, stageSizeY, Xn, Yn, sizeMines, sizeCell, sizeAttempts, nameUser, lvlNumber1, lvlNumber2, lvlNumber3, lvlNumberCustom, errorSizeStage, errorSizeCell, errorSizeMines, errorSizeAttempts, flagStage, flagCellSize, flagMinesSize, flagAttempts, levelID, screenBounds);

        MenuButtonController.goMenu(menu);

        stageSizeX.textProperty().addListener(stageSizeX -> SettingStringsModels.sizeStage(contextSetting));
        stageSizeY.textProperty().addListener(stageSizeY -> SettingStringsModels.sizeStage(contextSetting));


        Xn.textProperty().addListener(Xn -> SettingStringsModels.sizeXnYn(contextSetting));
        Yn.textProperty().addListener(Yn -> SettingStringsModels.sizeXnYn(contextSetting));


        sizeMines.textProperty().addListener(sizeMines -> SettingStringsModels.sizeMines(contextSetting));

        sizeAttempts.textProperty().addListener(sizeAttempts -> SettingStringsModels.sizeAttempts(contextSetting));

        levels.selectedToggleProperty().addListener((changed, oldValue, newValue) ->
        {
            RadioButton button = (RadioButton) newValue;
            if (!button.getText().equals(lvlNumberCustom.getText())) {
                SettingLevelModel.setSettingsFromFile(contextSetting, button.getText());
                SettingLevelModel.setLevelOrCustom(contextSetting, DISABLE_INPUT);
            } else {
                SettingLevelModel.setLevelOrCustom(contextSetting, ALLOW_INPUT);
            }
        });

        standardSetting.setOnAction(actionEvent -> {
            SettingLevelModel.setSettingsFromFile(contextSetting, this.standardSetting.getText());
            SettingLevelModel.selected(contextSetting);
        });
        currentSetting.setOnAction(actionEvent -> {
            SettingLevelModel.setSettingsFromFile(contextSetting, this.currentSetting.getText());
            SettingLevelModel.selected(contextSetting);
        });

        save.setOnAction(actionEvent -> WriterToFile.write(contextSetting, currentSetting.getText()));
    }
}
