package sapper.core;

import javafx.scene.paint.Color;
import sapper.contexts.ContextGame;

import java.io.File;

public class LoaderPicturesAndColors {
    private static final String FILE_ = "..\\lab3Java\\picture\\";
    private static final String FILE_PNG_FORMAT = ".png";
    private static final String FILE_BOOM = "..\\lab3Java\\picture\\boom.png";
    private static final String FILE_MINES = "..\\lab3Java\\picture\\mines.png";
    private static final String FILE_FLAG = "..\\lab3Java\\picture\\flag.png";
    private static final String FILE_RES = "..\\lab3Java\\picture\\res.png";
    private static final String FILE_MENU = "..\\lab3Java\\picture\\menu.png";
    private static final int BOOM = 0;
    private static final int MINES = 1;
    private static final int FLAG = 2;
    private static final int RESTART = 3;
    private static final int MENU = 4;
    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int COUNT_FROM_ONE = 1;

    public static void loadingPicturesAndColors(ContextGame contextGame) {
        File boom = new File(FILE_BOOM);
        File mines = new File(FILE_MINES);
        File flag = new File(FILE_FLAG);
        File Restart = new File(FILE_RES);
        File Menu = new File(FILE_MENU);
        contextGame.getPngSpecialObjects()[BOOM] = boom;
        contextGame.getPngSpecialObjects()[MINES] = mines;
        contextGame.getPngSpecialObjects()[FLAG] = flag;
        contextGame.getPngSpecialObjects()[RESTART] = Restart;
        contextGame.getPngSpecialObjects()[MENU] = Menu;

        for (int i = 0; i < contextGame.getPngNumbers().length; i++) {
            contextGame.getPngNumbers()[i] = new File(FILE_ + (i + COUNT_FROM_ONE) + FILE_PNG_FORMAT);
        }


        contextGame.getColors()[RED] = Color.RED;
        contextGame.getColors()[WHITE] = Color.WHITE;
    }
}
