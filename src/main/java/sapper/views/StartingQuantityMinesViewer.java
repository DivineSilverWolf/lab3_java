package sapper.views;

import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import sapper.contexts.ContextGame;

public class StartingQuantityMinesViewer {
    private final static double OPTIMAL_DISTANCE_0 = 0;
    private final static double OPTIMAL_DISTANCE_1 = 1.5;
    private final static double FONT = 20;

    public static void startingQuantityMinesView(ContextGame contextGame) {
        contextGame.getMinesToEnd().setFont(Font.font(FONT));
        contextGame.getMinesToEnd().setText(contextGame.getMinesSize() + "");
        AnchorPane.setRightAnchor(contextGame.getMinesToEnd(), OPTIMAL_DISTANCE_0);
        contextGame.getMinesToEnd().setX(contextGame.getSizeStageX() - contextGame.getMinesToEnd().getLayoutBounds().getWidth());
        contextGame.getMinesToEnd().setY(contextGame.getTIME_PAUSE_SIZE() / OPTIMAL_DISTANCE_1);
        contextGame.getRoot().getChildren().add(contextGame.getMinesToEnd());
    }
}
