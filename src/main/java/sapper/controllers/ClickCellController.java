package sapper.controllers;

import sapper.contexts.ContextGame;
import javafx.scene.input.MouseButton;
import sapper.contexts.WrapperInteger;
import sapper.models.LeftClickCellModel;
import sapper.models.RightClickCellModel;

public class ClickCellController {
    public void click(ContextGame contextGame) {
        contextGame.getRoot().setOnMouseClicked(MouseEvent -> {

            if (contextGame.getCountMines().get() == contextGame.getEnderGame())
                return;
            if (contextGame.getFlagStartTimer().get()) {
                contextGame.getTimeline().play();
                contextGame.getFlagStartTimer().set(!contextGame.getFlagStartTimer().get());
            }
            WrapperInteger wrapperInteger = processCoordinates(contextGame, MouseEvent.getX(), MouseEvent.getY());
            if (MouseEvent.getY() < contextGame.getTIME_PAUSE_SIZE())
                return;

            if (MouseEvent.getButton().name().equals(MouseButton.PRIMARY.name())) {
                LeftClickCellModel.leftClickCell(wrapperInteger.getX(), wrapperInteger.getY(), contextGame, wrapperInteger.getX1(), wrapperInteger.getY1());
            } else if (MouseEvent.getButton().name().equals(MouseButton.SECONDARY.name())) {
                RightClickCellModel.rightClickCell(wrapperInteger.getX(), wrapperInteger.getY(), contextGame, wrapperInteger.getX1(), wrapperInteger.getY1());
            }
        });
    }

    private static WrapperInteger processCoordinates(ContextGame contextGame, double x, double y) {
        x = x - x % contextGame.getSizeX();
        y = y - contextGame.getTIME_PAUSE_SIZE();
        y = y - y % contextGame.getSizeY();
        int X = (int) Math.round(x / contextGame.getSizeX());
        int Y = (int) Math.round(y / contextGame.getSizeY());
        if (X == contextGame.getXn())
            X--;
        else if (Y == contextGame.getYn())
            y--;
        WrapperInteger wrapperInteger = new WrapperInteger(x, y, X, Y);
        return wrapperInteger;
    }
}
