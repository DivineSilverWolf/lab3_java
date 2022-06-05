package sapper.controllers;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import sapper.core.App;

import java.io.IOException;

public class ButtonRestartController {
    public static void restart(Button restart, Stage stage) {
        restart.setOnAction(actionEvent -> {
            try {
                App.setGame(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
