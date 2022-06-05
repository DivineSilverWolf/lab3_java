package sapper.models;

import sapper.contexts.ContextSetting;
import sapper.views.IsDigitBigViewer;
import sapper.views.IsDigitErrorViewer;
import sapper.views.IsDigitSmallViewer;
import sapper.views.IsNotDigitViewer;


public class SettingStringsModels {
    private static String MINES = "Mines";
    private static String ATTEMPTS = "Attempts";
    private static double MIN_STAGE_X = 100;
    private static double MIN_STAGE_Y = 140;
    private static double MAX_SET_STAGE_Y = 100;
    private static String ERROR_X = "X";
    private static String ERROR_Y = "Y";
    private static String ERROR_XY = "XY";
    private static String ERROR_Xn = "Xn";
    private static String ERROR_Yn = "Yn";
    private static String ERROR_XnYn = "XnYn";
    private static int MIN_XnYn = 3;
    private static int MIN_MINES = 1;

    public static void sizeStage(ContextSetting contextSetting) {
        contextSetting.getFlagStage().set(false);
        if (IsNotDigitViewer.printErrorDigit(contextSetting.getStageSizeX(), contextSetting.getStageSizeY(), contextSetting.getErrorSizeStage(), ERROR_XY, ERROR_X, ERROR_Y)) {
            contextSetting.getFlagStage().set(IsDigitSmallViewer.isDigitSmallView(contextSetting.getErrorSizeStage(), contextSetting.getStageSizeX(), contextSetting.getStageSizeY(), MIN_STAGE_X, MIN_STAGE_Y, ERROR_XY, ERROR_X, ERROR_Y)
                    && IsDigitBigViewer.isDigitBigView(contextSetting.getErrorSizeStage(), contextSetting.getStageSizeX(), contextSetting.getStageSizeY(), contextSetting.getScreenBounds().getWidth(), contextSetting.getScreenBounds().getHeight() - MAX_SET_STAGE_Y, ERROR_XY, ERROR_X, ERROR_Y));
            if (contextSetting.getFlagCellSize().get())
                contextSetting.getSizeCell().setText(Integer.parseInt(contextSetting.getXn().getText()) * Integer.parseInt(contextSetting.getYn().getText()) + "");
            if (!contextSetting.getFlagStage().get())
                contextSetting.getSizeCell().setText("");

        }
    }

    final static int TIME_PAUSE_SIZE = 40;

    public static void sizeXnYn(ContextSetting contextSetting) {
        contextSetting.getSizeCell().setText("");
        contextSetting.getFlagCellSize().set(false);
        if (IsNotDigitViewer.printErrorDigit(contextSetting.getXn(), contextSetting.getYn(), contextSetting.getErrorSizeCell(), ERROR_XnYn, ERROR_Xn, ERROR_Yn)) {
            if (contextSetting.getFlagStage().get())
                if (IsDigitErrorViewer.isDigitErrorView(contextSetting.getErrorSizeCell(), Double.parseDouble(contextSetting.getStageSizeX().getText()) / Integer.parseInt(contextSetting.getXn().getText()), (Double.parseDouble(contextSetting.getStageSizeY().getText()) - TIME_PAUSE_SIZE) / Integer.parseInt(contextSetting.getYn().getText()), 10, 10, "XnYn", "Xn", "Yn")) {
                    if (IsDigitSmallViewer.isDigitSmallView(contextSetting.getErrorSizeCell(), contextSetting.getXn(), contextSetting.getYn(), MIN_XnYn, MIN_XnYn, ERROR_XnYn, ERROR_Xn, ERROR_Yn)) {
                        contextSetting.getSizeCell().setText(Integer.parseInt(contextSetting.getXn().getText()) * Integer.parseInt(contextSetting.getYn().getText()) + "");
                        contextSetting.getFlagCellSize().set(true);
                    }
                }
        }
    }

    public static void sizeMines(ContextSetting contextSetting) {
        contextSetting.getFlagMinesSize().set(false);
        if (IsNotDigitViewer.printErrorDigit(contextSetting.getXn(), contextSetting.getYn(), contextSetting.getErrorSizeCell(), ERROR_XnYn, ERROR_Xn, ERROR_Yn)) {
            if (IsNotDigitViewer.printErrorDigit(contextSetting.getSizeMines(), contextSetting.getErrorSizeMines(), MINES)) {
                contextSetting.getFlagMinesSize().set(true);
                contextSetting.getErrorSizeMines().setText("");
                if (Integer.parseInt(contextSetting.getXn().getText()) * Integer.parseInt(contextSetting.getYn().getText()) <= Integer.parseInt(contextSetting.getSizeMines().getText())) {
                    contextSetting.getFlagMinesSize().set(false);
                    contextSetting.getErrorSizeMines().setText(Integer.parseInt(contextSetting.getXn().getText()) * Integer.parseInt(contextSetting.getYn().getText()) + "<=" + Integer.parseInt(contextSetting.getSizeMines().getText()));
                }
            }
        }
    }

    public static void sizeAttempts(ContextSetting contextSetting) {
        contextSetting.getFlagAttempts().set(false);
        if (IsNotDigitViewer.printErrorDigit(contextSetting.getSizeMines(), contextSetting.getErrorSizeMines(), MINES)) {
            contextSetting.getErrorSizeAttempts().setText("");
            if (IsNotDigitViewer.printErrorDigit(contextSetting.getSizeAttempts(), contextSetting.getErrorSizeAttempts(), ATTEMPTS)) {
                if (Integer.parseInt(contextSetting.getSizeAttempts().getText()) < MIN_MINES || Integer.parseInt(contextSetting.getSizeAttempts().getText()) > Integer.parseInt(contextSetting.getSizeMines().getText())) {
                    contextSetting.getErrorSizeAttempts().setText(MIN_MINES + "<" + contextSetting.getSizeAttempts().getText() + "<=" + contextSetting.getSizeMines().getText());
                } else
                    contextSetting.getFlagAttempts().set(true);
            }
        }
    }


}
