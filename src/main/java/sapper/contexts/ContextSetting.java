package sapper.contexts;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ContextSetting {
    private final Button save;
    private final TextField stageSizeX;
    private final TextField stageSizeY;
    private TextField Xn;
    private TextField Yn;
    private TextField sizeMines;
    private final TextField sizeCell;
    private TextField sizeAttempts;
    private final TextField nameUser;
    private final RadioButton lvlNumber1;
    private final RadioButton lvlNumber2;
    private final RadioButton lvlNumber3;
    private final RadioButton lvlNumberCustom;
    private final Text errorSizeStage;
    private final Text errorSizeCell;
    private final Text errorSizeMines;
    private final Text errorSizeAttempts;
    private final AtomicBoolean flagStage;
    private final AtomicBoolean flagCellSize;
    private final AtomicBoolean flagMinesSize;
    private final AtomicBoolean flagAttempts;
    private final Rectangle2D screenBounds;

    public Rectangle2D getScreenBounds() {
        return screenBounds;
    }

    public ContextSetting(Button save, TextField stageSizeX, TextField stageSizeY, TextField xn, TextField yn, TextField sizeMines, TextField sizeCell, TextField sizeAttempts, TextField nameUser, RadioButton lvlNumber1, RadioButton lvlNumber2, RadioButton lvlNumber3, RadioButton lvlNumberCustom, Text errorSizeStage, Text errorSizeCell, Text errorSizeMines, Text errorSizeAttempts, AtomicBoolean flagStage, AtomicBoolean flagCellSize, AtomicBoolean flagMinesSize, AtomicBoolean flagAttempts, AtomicReference<String> levelID, Rectangle2D screenBounds) {
        this.screenBounds = screenBounds;
        this.save = save;
        this.stageSizeX = stageSizeX;
        this.stageSizeY = stageSizeY;
        Xn = xn;
        Yn = yn;
        this.sizeMines = sizeMines;
        this.sizeCell = sizeCell;
        this.sizeAttempts = sizeAttempts;
        this.nameUser = nameUser;
        this.lvlNumber1 = lvlNumber1;
        this.lvlNumber2 = lvlNumber2;
        this.lvlNumber3 = lvlNumber3;
        this.lvlNumberCustom = lvlNumberCustom;
        this.errorSizeStage = errorSizeStage;
        this.errorSizeCell = errorSizeCell;
        this.errorSizeMines = errorSizeMines;
        this.errorSizeAttempts = errorSizeAttempts;
        this.flagStage = flagStage;
        this.flagCellSize = flagCellSize;
        this.flagMinesSize = flagMinesSize;
        this.flagAttempts = flagAttempts;
        this.levelID = levelID;
    }

    public Button getSave() {
        return save;
    }


    public TextField getStageSizeX() {
        return stageSizeX;
    }


    public TextField getStageSizeY() {
        return stageSizeY;
    }


    public TextField getXn() {
        return Xn;
    }

    public void setXn(TextField xn) {
        Xn = xn;
    }

    public TextField getYn() {
        return Yn;
    }

    public void setYn(TextField yn) {
        Yn = yn;
    }

    public TextField getSizeMines() {
        return sizeMines;
    }

    public void setSizeMines(TextField sizeMines) {
        this.sizeMines = sizeMines;
    }

    public TextField getSizeCell() {
        return sizeCell;
    }


    public TextField getSizeAttempts() {
        return sizeAttempts;
    }

    public void setSizeAttempts(TextField sizeAttempts) {
        this.sizeAttempts = sizeAttempts;
    }

    public TextField getNameUser() {
        return nameUser;
    }

    public RadioButton getLvlNumber1() {
        return lvlNumber1;
    }

    public RadioButton getLvlNumber2() {
        return lvlNumber2;
    }

    public RadioButton getLvlNumber3() {
        return lvlNumber3;
    }

    public RadioButton getLvlNumberCustom() {
        return lvlNumberCustom;
    }

    public Text getErrorSizeStage() {
        return errorSizeStage;
    }

    public Text getErrorSizeCell() {
        return errorSizeCell;
    }

    public Text getErrorSizeMines() {
        return errorSizeMines;
    }

    public Text getErrorSizeAttempts() {
        return errorSizeAttempts;
    }

    public AtomicBoolean getFlagStage() {
        return flagStage;
    }

    public AtomicBoolean getFlagCellSize() {
        return flagCellSize;
    }

    public AtomicBoolean getFlagMinesSize() {
        return flagMinesSize;
    }

    public AtomicBoolean getFlagAttempts() {
        return flagAttempts;
    }

    public AtomicReference<String> getLevelID() {
        return levelID;
    }

    AtomicReference<String> levelID;
}
