package sapper.models;

import sapper.contexts.ContextSetting;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriterToFile {

    /*здесь не делал констант, потому что очевидно мы, к примеру,
    соотносим для StageSizeX из contextSetting
    настройки из "StageSizeX"
    */
    private static String FILE_NAME = "..\\lab3Java\\Settings\\";

    public static void write(ContextSetting contextSetting, String fileName) {
        if (!(contextSetting.getFlagAttempts().get() && contextSetting.getFlagStage().get() && contextSetting.getFlagCellSize().get() && contextSetting.getFlagMinesSize().get())) {
            contextSetting.getSave().setStyle("-fx-background-color: #ff0000; -fx-border-color: #000000;");
            return;
        }
        contextSetting.getSave().setStyle("-fx-background-color: #423189; -fx-border-color: #000000;");

        try (java.io.OutputStreamWriter push = new java.io.OutputStreamWriter(new FileOutputStream(FILE_NAME + fileName))) {
            String wordFrequencyPercent = "StageSizeX " + contextSetting.getStageSizeX().getText() + "\nStageSizeY " + contextSetting.getStageSizeY().getText() + "\nXn " + contextSetting.getXn().getText() + "\nYn " +
                    contextSetting.getYn().getText() + "\nSizeMines " + contextSetting.getSizeMines().getText() + "\nSizeAttempts " + contextSetting.getSizeAttempts().getText() + "\nLevelID " + contextSetting.getLevelID().get() + "\nName " + contextSetting.getNameUser().getText();
            push.write(wordFrequencyPercent);

        } catch (IOException e) {
            contextSetting.getSave().setStyle("-fx-background-color: #ff0000; -fx-border-color: #000000;");
            e.printStackTrace();
        }
    }
}
