package sapper.models;

import sapper.contexts.ContextGame;
import sapper.rating.RecordHandler;
import sapper.views.CellViewer;

public class ClickerMine {
    private static int MINES = -1;
    private static int MINES_PNG = 1;
    private static int BIOS = 1;
    private static int MINES_BOOM = 0;
    private static int MINES_RED = 0;
    private static boolean LOSE = true;

    public static void clickMine(ContextGame contextGame, int X, int Y, int x, int y) {
        contextGame.getMinesToEnd().setText((Integer.parseInt(contextGame.getMinesToEnd().getText()) - BIOS) + "");
        contextGame.getCells()[Y][X].setVisibility(!contextGame.getCells()[Y][X].getVisibility());
        CellViewer.cellViewer(contextGame.getRoot(), contextGame.getPngSpecialObjects()[MINES_BOOM], contextGame.getColors()[MINES_RED], x, y + contextGame.getTIME_PAUSE_SIZE(), contextGame.getSizeX(), contextGame.getSizeY());
        if (contextGame.getCountMines().incrementAndGet() == contextGame.getEnderGame()) {
            if (contextGame.getStackMinesSizeCords().isEmpty()) {
                for (int yl = 0; yl < contextGame.getYn(); yl++) {
                    for (int xl = 0; xl < contextGame.getXn(); xl++) {
                        if (contextGame.getCells()[yl][xl].getNumberOrMine() == MINES && !contextGame.getCells()[yl][xl].getVisibility()) {
                            CellViewer.cellViewer(contextGame.getRoot(), contextGame.getPngSpecialObjects()[1], null, xl * contextGame.getSizeX(), yl * contextGame.getSizeY() + contextGame.getTIME_PAUSE_SIZE(), contextGame.getSizeX(), contextGame.getSizeY());
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
            contextGame.getLoser().set(LOSE);
            RecordHandler.goRecord(contextGame);
            contextGame.getTimeline().stop();
        }
    }
}
