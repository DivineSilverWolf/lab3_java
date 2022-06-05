package sapper.settings;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class Settings {
    private static final String FXML_FORMAT = ".fxml";
    public static void setRoot(String fxml, Scene scene) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Settings.class.getResource(fxml + FXML_FORMAT));
        return fxmlLoader.load();
    }
}
