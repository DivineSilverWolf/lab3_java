package sapper.contexts;

import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sapper.core.MinesweeperСell;

import java.io.File;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ContextGame {
    private final Stage stage;
    private final int minesSize;
    private final int TIME_PAUSE_SIZE;
    private final int xn;
    private final double sizeX;
    private final int yn;
    private final double sizeY;
    private final int enderGame;
    private final MinesweeperСell[][] cells;
    private final Stack<Integer> stackMinesSizeCords;
    private final Text text;
    private final AtomicInteger[] time;
    private final File[] pngSpecialObjects;
    private final File[] pngNumbers;
    private final Color[] colors;
    private final Text minesToEnd;
    private final Button restart;
    private final AnchorPane root;
    private final int sizeStageX;
    private final int sizeStageY;
    private Timeline timeline;
    private final String nameUser;
    private final String levelID;
    private final Button menu;
    private final AtomicInteger countMines;
    private final AtomicBoolean flagStartTimer;
    private final AtomicBoolean loser;
    private final AtomicBoolean winner = new AtomicBoolean(false);

    public AtomicBoolean getWinner() {
        return winner;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public Stage getStage() {
        return stage;
    }

    public int getMinesSize() {
        return minesSize;
    }

    public int getTIME_PAUSE_SIZE() {
        return TIME_PAUSE_SIZE;
    }

    public int getXn() {
        return xn;
    }

    public double getSizeX() {
        return sizeX;
    }

    public int getYn() {
        return yn;
    }

    public double getSizeY() {
        return sizeY;
    }

    public int getEnderGame() {
        return enderGame;
    }

    public MinesweeperСell[][] getCells() {
        return cells;
    }

    public Stack<Integer> getStackMinesSizeCords() {
        return stackMinesSizeCords;
    }

    public Text getText() {
        return text;
    }

    public AtomicInteger[] getTime() {
        return time;
    }

    public File[] getPngSpecialObjects() {
        return pngSpecialObjects;
    }

    public File[] getPngNumbers() {
        return pngNumbers;
    }

    public Color[] getColors() {
        return colors;
    }

    public Text getMinesToEnd() {
        return minesToEnd;
    }

    public Button getRestart() {
        return restart;
    }

    public Button getMenu() {
        return menu;
    }

    public AtomicInteger getCountMines() {
        return countMines;
    }

    public AtomicBoolean getFlagStartTimer() {
        return flagStartTimer;
    }

    public AnchorPane getRoot() {
        return root;
    }

    public int getSizeStageX() {
        return sizeStageX;
    }

    public int getSizeStageY() {
        return sizeStageY;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getLevelID() {
        return levelID;
    }

    public AtomicBoolean getLoser() {
        return loser;
    }

    public ContextGame(Stage stage, int minesSize, int TIME_PAUSE_SIZE, int xn, double sizeX, int yn, double sizeY, int enderGame, MinesweeperСell[][] cells, Stack<Integer> stackMinesSizeCords, Text text, AtomicInteger[] time, File[] pngSpecialObjects, File[] pngNumbers, Color[] colors, Text minesToEnd, Button restart, Button menu, AtomicInteger countMines, AtomicBoolean flagStartTimer, AnchorPane root, int sizeStageX, int sizeStageY, String nameUser, String levelID, AtomicBoolean loser) {
        this.loser = loser;
        this.levelID = levelID;
        this.nameUser = nameUser;
        this.sizeStageX = sizeStageX;
        this.sizeStageY = sizeStageY;
        this.root = root;
        this.stage = stage;
        this.minesSize = minesSize;
        this.TIME_PAUSE_SIZE = TIME_PAUSE_SIZE;
        this.xn = xn;
        this.sizeX = sizeX;
        this.yn = yn;
        this.sizeY = sizeY;
        this.enderGame = enderGame;
        this.cells = cells;
        this.stackMinesSizeCords = stackMinesSizeCords;
        this.text = text;
        this.time = time;
        this.pngSpecialObjects = pngSpecialObjects;
        this.pngNumbers = pngNumbers;
        this.colors = colors;
        this.minesToEnd = minesToEnd;
        this.restart = restart;
        this.menu = menu;
        this.countMines = countMines;
        this.flagStartTimer = flagStartTimer;
    }


}
