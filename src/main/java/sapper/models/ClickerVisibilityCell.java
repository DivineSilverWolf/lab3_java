package sapper.models;

import sapper.contexts.ContextGame;
import sapper.rating.RecordHandler;
import sapper.views.CellViewer;

public class ClickerVisibilityCell {
    private static int BIOS = 1;
    private static int MINES_PNG = 1;
    private static int MINES = -1;
    private static int CELL = 0;
    private static int START = 0;
    private static int SIZE_CELL = 8;
    private static int RED = 0;
    private static int WHITE = 1;
    private static int BOOM = 0;
    private static int FLAG_PNG = 2;

    public static void clickCell(ContextGame contextGame, int X, int Y) {
        int countVisibility = START;
        int countFlags = START;
        for (int i = -BIOS; i <= BIOS; i++) {
            for (int j = -BIOS; j <= BIOS; j++) {
                if (i + Y > -BIOS && j + X > -BIOS && i + Y < contextGame.getYn() && j + X < contextGame.getXn() && (i * i + j * j != CELL)) {
                    if (contextGame.getCells()[i + Y][j + X].getFlag() || (contextGame.getCells()[i + Y][j + X].getNumberOrMine() == MINES && contextGame.getCells()[i + Y][j + X].getVisibility()))
                        countFlags++;
                    if (contextGame.getCells()[i + Y][j + X].getVisibility() || contextGame.getCells()[i + Y][j + X].getFlag())
                        countVisibility++;
                }
            }
        }
        if (countFlags == contextGame.getCells()[Y][X].getNumberOrMine() && countVisibility != SIZE_CELL) {
            for (int i = -BIOS; i <= BIOS; i++) {
                for (int j = -BIOS; j <= BIOS; j++) {
                    if (i + Y > -BIOS && j + X > -BIOS && i + Y < contextGame.getYn() && j + X < contextGame.getXn() && (i * i + j * j != START) && (!contextGame.getCells()[Y + i][X + j].getVisibility())) {
                        if (contextGame.getCells()[Y + i][X + j].getNumberOrMine() == MINES && !contextGame.getCells()[Y + i][X + j].getFlag()) {
                            contextGame.getMinesToEnd().setText((Integer.parseInt(contextGame.getMinesToEnd().getText()) - BIOS) + "");
                            contextGame.getCells()[Y + i][X + j].setVisibility(!contextGame.getCells()[Y + i][X + j].getVisibility());
                            CellViewer.cellViewer(contextGame.getRoot(), contextGame.getPngSpecialObjects()[BOOM], contextGame.getColors()[RED], (X + j) * contextGame.getSizeX(), (Y + i) * contextGame.getSizeY() + contextGame.getTIME_PAUSE_SIZE(), contextGame.getSizeX(), contextGame.getSizeY());
                            if (contextGame.getCountMines().incrementAndGet() == contextGame.getEnderGame()) {
                                if (contextGame.getStackMinesSizeCords().isEmpty()) {
                                    for (int yl = START; yl < contextGame.getYn(); yl++) {
                                        for (int xl = START; xl < contextGame.getXn(); xl++) {
                                            if (contextGame.getCells()[yl][xl].getNumberOrMine() == MINES && !contextGame.getCells()[yl][xl].getVisibility()) {
                                                CellViewer.cellViewer(contextGame.getRoot(), contextGame.getPngSpecialObjects()[FLAG_PNG], null, xl * contextGame.getSizeX(), yl * contextGame.getSizeY() + contextGame.getTIME_PAUSE_SIZE(), contextGame.getSizeX(), contextGame.getSizeY());
                                            }
                                        }
                                    }
                                } else {
                                    while (!contextGame.getStackMinesSizeCords().isEmpty()) {
                                        int stackX = contextGame.getStackMinesSizeCords().pop();
                                        int stackY = contextGame.getStackMinesSizeCords().pop();

                                        if (!contextGame.getCells()[stackY][stackX].getVisibility()) {
                                            CellViewer.cellViewer(contextGame.getRoot(), contextGame.getPngSpecialObjects()[MINES_PNG], null, stackX * contextGame.getSizeX(), stackY * contextGame.getSizeY() + contextGame.getTIME_PAUSE_SIZE(), contextGame.getSizeX(), contextGame.getSizeY());
                                        }
                                    }
                                }

                                contextGame.getLoser().set(true);
                                RecordHandler.goRecord(contextGame);
                                contextGame.getTimeline().stop();
                            }
                        }
                        LeftClickCellModel.recursiveCall(contextGame, contextGame.getColors()[WHITE], X + j, Y + i);
                    }
                }
            }
        }
    }
}
