package sapper.models;

import sapper.contexts.ContextGame;
import sapper.views.CellViewer;

public class RightClickCellModel {
    private static int FLAG_PNG = 2;
    private static int CHANGE_QUANTITY = 1;

    public static void rightClickCell(double x, double y, ContextGame contextGame, int X, int Y) {


        if (contextGame.getCells()[Y][X].getVisibility())
            return;

        contextGame.getCells()[Y][X].setFlag(!contextGame.getCells()[Y][X].getFlag());

        if (contextGame.getCells()[Y][X].getFlag() && contextGame.getCells()[Y][X].getFlagImage() == null) {
            if (isDigit(contextGame.getMinesToEnd().getText()))
                contextGame.getMinesToEnd().setText((Integer.parseInt(contextGame.getMinesToEnd().getText()) - CHANGE_QUANTITY) + "");
            contextGame.getCells()[Y][X].setFlagImage(CellViewer.cellViewer(contextGame.getRoot(), contextGame.getPngSpecialObjects()[FLAG_PNG], null, x, y + contextGame.getTIME_PAUSE_SIZE(), contextGame.getSizeX(), contextGame.getSizeY()));
        } else if (contextGame.getCells()[Y][X].getFlag() && contextGame.getCells()[Y][X].getFlagImage() != null) {
            if (isDigit(contextGame.getMinesToEnd().getText()))
                contextGame.getMinesToEnd().setText((Integer.parseInt(contextGame.getMinesToEnd().getText()) - CHANGE_QUANTITY) + "");
            contextGame.getRoot().getChildren().add(contextGame.getCells()[Y][X].getFlagImage());
        } else {
            if (isDigit(contextGame.getMinesToEnd().getText()))
                contextGame.getMinesToEnd().setText((Integer.parseInt(contextGame.getMinesToEnd().getText()) + CHANGE_QUANTITY) + "");
            contextGame.getRoot().getChildren().remove(contextGame.getCells()[Y][X].getFlagImage());
        }

    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }
}
