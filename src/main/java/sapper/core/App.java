package sapper.core;

import sapper.contexts.ContextGame;
import sapper.controllers.ButtonRestartController;
import sapper.controllers.ClickCellController;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sapper.controllers.MenuButtonController;
import sapper.views.LineViewer;
import sapper.views.RestartAndMenuButtonViewer;

import sapper.views.StartingQuantityMinesViewer;

import java.io.*;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static final String MENU_DEF = "MENU";
    private static final double STAGE_SIZE_X = 600;
    private static final double STAGE_SIZE_Y = 400;
    private static final String SAPPER_PREV = "Sapper";
    private static final String FXML_FORMAT = ".fxml";
    private static final int BIOS_LEFT = 0;
    private static final int BIOS_RIGHT = 1;
    private static final int RESTART = 3;
    private static final int MENU = 4;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(MENU_DEF), STAGE_SIZE_X, STAGE_SIZE_Y);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
    }

    public static void setGame(Stage stage) throws IOException {
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: lightGray");

        ContextGame contextGame = LoaderParam.loading(stage, root);
        Scene scene = new Scene(root, contextGame.getSizeStageX(), contextGame.getSizeStageY());

        LineViewer.linesView(contextGame);
        FieldLoader.loadField(contextGame);

        Timeline timeline = Timer.loadTimer(contextGame);
        contextGame.setTimeline(timeline);

        LoaderPicturesAndColors.loadingPicturesAndColors(contextGame);
        StartingQuantityMinesViewer.startingQuantityMinesView(contextGame);

        ClickCellController clickCellController = new ClickCellController();
        clickCellController.click(contextGame);

        RestartAndMenuButtonViewer.restartOrMenuButtonView(contextGame.getRestart(), contextGame, contextGame.getPngSpecialObjects()[RESTART], BIOS_LEFT);
        ButtonRestartController.restart(contextGame.getRestart(), stage);

        RestartAndMenuButtonViewer.restartOrMenuButtonView(contextGame.getMenu(), contextGame, contextGame.getPngSpecialObjects()[MENU], BIOS_RIGHT);
        MenuButtonController.goMenu(contextGame.getMenu());
        stage.centerOnScreen();
        stage.setTitle(SAPPER_PREV);
        stage.setScene(scene);
        stage.show();
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + FXML_FORMAT));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}