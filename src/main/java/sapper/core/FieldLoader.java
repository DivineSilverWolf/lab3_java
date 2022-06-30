package sapper.core;

import sapper.contexts.ContextGame;

import java.util.Random;

public class FieldLoader {
    private static final int CELL = 0;
    private static final int MINES = -1;
    private static final int BIOS = 1;
    private static final int HALF = 2;
    private static final boolean FLAG_DEF = false;
    private static final boolean VISIBILITY_DEF = false;
    private static final int BORDER = -1;
    private static final int START = 0;

    public static void loadField(ContextGame contextGame) {
        Random random = new Random();
        int numberOrMine;
        if (contextGame.getMinesSize() < contextGame.getXn() * contextGame.getYn() / HALF)
            numberOrMine = CELL;
        else
            numberOrMine = MINES;

        for (int i = START; i < contextGame.getYn(); i++) {
            for (int j = START; j < contextGame.getXn(); j++) {
                contextGame.getCells()[i][j] = new MinesweeperСell(FLAG_DEF, VISIBILITY_DEF, numberOrMine);
            }
        }
        if (contextGame.getMinesSize() < contextGame.getXn() * contextGame.getYn() / HALF) {
            for (int i = START; i < contextGame.getMinesSize(); i++) {
                int randX = random.nextInt(contextGame.getXn() - BIOS);
                int randY = random.nextInt(contextGame.getYn() - BIOS);
                if (contextGame.getCells()[randY][randX].getNumberOrMine() == MINES) {
                    --i;
                } else {
                    contextGame.getCells()[randY][randX].setNumberOrMine(MINES);
                    contextGame.getStackMinesSizeCords().push(randY);
                    contextGame.getStackMinesSizeCords().push(randX);
                }
            }
        } else {
            for (int i = 0; i < contextGame.getYn() * contextGame.getXn() - contextGame.getMinesSize(); i++) {
                int randX = random.nextInt(contextGame.getXn() - BIOS);
                int randY = random.nextInt(contextGame.getYn() - BIOS);
                if (contextGame.getCells()[randY][randX].getNumberOrMine() == CELL) {
                    --i;
                } else
                    contextGame.getCells()[randY][randX].setNumberOrMine(CELL);
            }
        }

        for (int i = START; i < contextGame.getYn(); i++) {
            for (int j = START; j < contextGame.getXn(); j++) {
                if (contextGame.getCells()[i][j].getNumberOrMine() != MINES) {
                    int countMines = START;
                    for (int y = -BIOS; y <= BIOS; y++) {
                        for (int x = -BIOS; x <= BIOS; x++) {
                            if (i + y > BORDER && j + x > BORDER && i + y < contextGame.getYn() && j + x < contextGame.getXn() && (x * x + y * y) != START) {
                                if (contextGame.getCells()[i + y][j + x].getNumberOrMine() == MINES)
                                    countMines++;
                            }
                        }
                    }
                    contextGame.getCells()[i][j].setNumberOrMine(countMines);
                }
            }
        }
    }
}
