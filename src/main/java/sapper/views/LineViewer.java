package sapper.views;

import javafx.scene.shape.Line;
import sapper.contexts.ContextGame;

public class LineViewer {
    private static double ORDER = 10;

    public static void linesView(ContextGame contextGame) {
        for (int i = 0; i < Math.round(contextGame.getSizeStageX() / contextGame.getSizeX()); i++) {
            Line line = new Line(i * contextGame.getSizeX(), contextGame.getTIME_PAUSE_SIZE(), i * contextGame.getSizeX(), contextGame.getSizeStageY());
            line.setViewOrder(ORDER);
            contextGame.getRoot().getChildren().add(line);
        }
        for (int i = 0; i < Math.round(contextGame.getSizeStageY() / contextGame.getSizeY()); i++) {
            Line line = new Line(0, i * contextGame.getSizeY() + contextGame.getTIME_PAUSE_SIZE(), contextGame.getSizeStageX(), i * contextGame.getSizeY() + contextGame.getTIME_PAUSE_SIZE());
            line.setViewOrder(ORDER);
            contextGame.getRoot().getChildren().add(line);
        }
    }
}
