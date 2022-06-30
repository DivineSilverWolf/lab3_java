package sapper.controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sapper.core.App;

import java.io.IOException;

public class MenuButtonController {
    private static final String MENU = "Menu";
    private static final double STAGE_SIZE_X = 600;
    private static final double STAGE_SIZE_Y = 400;

    public static void goMenu(Button menu) {
        menu.setOnAction(actionEvent -> {
            Scene scene = new Scene(new AnchorPane(), STAGE_SIZE_X, STAGE_SIZE_Y);
            try {
                scene.setRoot(App.loadFXML(MENU));
                Stage stage = (Stage) menu.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
