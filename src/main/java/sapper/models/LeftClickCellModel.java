package sapper.models;

import sapper.contexts.ContextGame;
import javafx.scene.paint.Color;
import sapper.rating.RecordHandler;
import sapper.views.CellViewer;


public class LeftClickCellModel {
    private static int BIAS = 1;
    private static int MINES = -1;
    private static int CELL = 0;
    private static int START = 0;
    private static int WHITE = 1;

    public static void leftClickCell(double x, double y, ContextGame contextGame, int X, int Y) {

        if (contextGame.getCells()[Y][X].getFlag())
            return;


        if (contextGame.getCells()[Y][X].getVisibility()) {
            ClickerVisibilityCell.clickCell(contextGame, X, Y);
            if (closedСellСheck(contextGame)) {
                contextGame.getCountMines().set(contextGame.getEnderGame());
                RecordHandler.goRecord(contextGame);
                contextGame.getTimeline().stop();
            }
            return;
        }

        if (contextGame.getCells()[Y][X].getNumberOrMine() == -BIAS) {
            ClickerMine.clickMine(contextGame, X, Y, (int) x, (int) y);
        }

        recursiveCall(contextGame, contextGame.getColors()[WHITE], X, Y);
        if (closedСellСheck(contextGame)) {
            contextGame.getCountMines().set(contextGame.getEnderGame());
            RecordHandler.goRecord(contextGame);
            contextGame.getTimeline().stop();
        }

    }


    public static void recursiveCall(ContextGame contextGame, Color color, int X, int Y) {
        if (contextGame.getCells()[Y][X].getFlag() || contextGame.getCells()[Y][X].getVisibility() || contextGame.getCells()[Y][X].getNumberOrMine() == MINES)
            return;
        contextGame.getCells()[Y][X].setVisibility(true);
        if (contextGame.getCells()[Y][X].getNumberOrMine() != MINES && contextGame.getCells()[Y][X].getNumberOrMine() != CELL) {
            CellViewer.cellViewer(contextGame.getRoot(), contextGame.getPngNumbers()[contextGame.getCells()[Y][X].getNumberOrMine() - BIAS], color, contextGame.getSizeX() * X, contextGame.getSizeY() * Y + contextGame.getTIME_PAUSE_SIZE(), contextGame.getSizeX(), contextGame.getSizeY());
        } else if (contextGame.getCells()[Y][X].getNumberOrMine() == CELL) {
            CellViewer.cellViewer(contextGame.getRoot(), null, color, contextGame.getSizeX() * X, contextGame.getSizeY() * Y + contextGame.getTIME_PAUSE_SIZE(), contextGame.getSizeX(), contextGame.getSizeY());
            for (int i = -BIAS; i <= BIAS; i++) {
                for (int j = -BIAS; j <= BIAS; j++) {
                    if (i + Y > -BIAS && j + X > -BIAS && i + Y < contextGame.getYn() && j + X < contextGame.getXn() && (i * i + j * j) != START) {
                        if (contextGame.getCells()[i + Y][j + X].getNumberOrMine() != MINES) {
                            recursiveCall(contextGame, color, j + X, i + Y);
                        }
                    }
                }
            }

        }
        if (closedСellСheck(contextGame)) {
            contextGame.getCountMines().set(contextGame.getEnderGame());
            RecordHandler.goRecord(contextGame);
            contextGame.getTimeline().stop();
        }
    }

    private static boolean closedСellСheck(ContextGame contextGame) {
        int size = START;
        for (int i = START; i < contextGame.getYn(); i++) {
            for (int j = START; j < contextGame.getXn(); j++) {
                if (contextGame.getCells()[i][j].getVisibility() && contextGame.getCells()[i][j].getNumberOrMine() != -1) {
                    size++;
                }
            }
        }
        if (size == contextGame.getXn() * contextGame.getYn() - contextGame.getMinesSize()) {
            return true;
        }
        return false;

    }
}
