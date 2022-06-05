package sapper.views;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import sapper.contexts.ContextGame;

import java.io.File;
import java.net.MalformedURLException;

public class RestartAndMenuButtonViewer {
    private static double LOCATION_Y = 0;
    private static double ORDER = 15;

    public static void restartOrMenuButtonView(Button restartOrMenu, ContextGame contextGame, File png, int minusOrPlusOffset) {
        try {
            String localUrl = png.toURI().toURL().toString();
            ImageView image = new ImageView(localUrl);
            image.setFitWidth(contextGame.getTIME_PAUSE_SIZE());
            image.setFitHeight(contextGame.getTIME_PAUSE_SIZE());
            contextGame.getRoot().getChildren().add(image);
            restartOrMenu.graphicProperty().setValue(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        restartOrMenu.setMaxWidth(contextGame.getTIME_PAUSE_SIZE());
        restartOrMenu.setMinWidth(contextGame.getTIME_PAUSE_SIZE());
        restartOrMenu.setLayoutX((contextGame.getSizeStageX()) / 2 - contextGame.getTIME_PAUSE_SIZE() * minusOrPlusOffset);
        restartOrMenu.setLayoutY(LOCATION_Y);
        restartOrMenu.setMaxHeight(contextGame.getTIME_PAUSE_SIZE());
        restartOrMenu.setMinHeight(contextGame.getTIME_PAUSE_SIZE());
        restartOrMenu.setViewOrder(ORDER);
        restartOrMenu.setStyle("-fx-background-color: #a0a0a4");
        restartOrMenu.setStyle("-fx-border-color: white");
        contextGame.getRoot().getChildren().add(restartOrMenu);
    }
}
