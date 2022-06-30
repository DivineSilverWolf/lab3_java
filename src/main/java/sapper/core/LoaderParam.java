package sapper.core;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sapper.contexts.ContextGame;
import sapper.models.CurrentSettingsCopier;

import java.io.File;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class LoaderParam {
    private final static int STAGE_SIZE_X = 0;
    private final static int STAGE_SIZE_Y = 1;
    private final static int XN = 2;
    private final static int YN = 3;
    private final static int SIZE_MINES = 4;
    private final static int SIZE_ATTEMPTS = 5;
    private final static int LEVEL_ID = 6;
    private final static int NAME = 7;
    private final static int TIME_PAUSE_SIZE = 40;
    private final static int TIMER_SIZE = 3;
    private final static int COLOR_SIZE = 2;
    private final static int PNG_NUMBERS_SIZE = 8;
    private final static int PNG_SPECIAL_OBJECTS_SIZE = 5;
    private final static boolean START_TIMER = true;

    public static ContextGame loading(Stage stage, AnchorPane root) {
        String[] data = CurrentSettingsCopier.copyCurrentSettings();
        int minesSize = Integer.parseInt(data[SIZE_MINES]);
        int sizeStageX = Integer.parseInt(data[STAGE_SIZE_X]);
        int sizeStageY = Integer.parseInt(data[STAGE_SIZE_Y]);
        int xn = Integer.parseInt(data[XN]);
        double sizeX = sizeStageX / (double) xn;
        int yn = Integer.parseInt(data[YN]);
        double sizeY = (sizeStageY - TIME_PAUSE_SIZE) / (double) yn;
        int enderGame = Integer.parseInt(data[SIZE_ATTEMPTS]);

        AtomicInteger countMines = new AtomicInteger();
        AtomicBoolean flagStartTimer = new AtomicBoolean(START_TIMER);
        File[] pngSpecialObjects = new File[PNG_SPECIAL_OBJECTS_SIZE];
        File[] pngNumbers = new File[PNG_NUMBERS_SIZE];
        Color[] colors = new Color[COLOR_SIZE];
        Text text = new Text();
        Text minesToEnd = new Text();
        AtomicInteger[] time = new AtomicInteger[TIMER_SIZE];
        MinesweeperСell[][] cells = new MinesweeperСell[yn][xn];
        Stack<Integer> stackMinesSizeCords = new Stack<>();
        Button restart = new Button();
        Button menu = new Button();

        ContextGame contextGame = new ContextGame(stage, minesSize, TIME_PAUSE_SIZE, xn, sizeX, yn, sizeY, enderGame, cells, stackMinesSizeCords, text, time, pngSpecialObjects, pngNumbers, colors, minesToEnd, restart, menu, countMines, flagStartTimer, root, sizeStageX, sizeStageY, data[NAME], data[LEVEL_ID], new AtomicBoolean(false));
        return contextGame;
    }
}
