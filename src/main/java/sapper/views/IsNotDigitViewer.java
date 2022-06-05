package sapper.views;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class IsNotDigitViewer {
    private final static String ERROR_IS_NOT_DIGIT = "Введено не число ";

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean printErrorDigit(TextField SizeX, TextField SizeY, Text errorSize, String XY, String X, String Y) {
        if (!isDigit(SizeX.getText()) || !isDigit(SizeY.getText())) {
            if (!isDigit(SizeX.getText()) && !isDigit(SizeY.getText()))
                errorSize.setText(ERROR_IS_NOT_DIGIT + XY);
            else if (!isDigit(SizeX.getText()))
                errorSize.setText(ERROR_IS_NOT_DIGIT + X);
            else if (!isDigit(SizeY.getText()))
                errorSize.setText(ERROR_IS_NOT_DIGIT + Y);
            return false;
        }
        errorSize.setText("");
        return true;
    }

    public static boolean printErrorDigit(TextField stageSizeX, Text errorSize, String X) {
        if (!isDigit(stageSizeX.getText())) {
            errorSize.setText(ERROR_IS_NOT_DIGIT + X);
            return false;
        }
        errorSize.setText("");
        return true;
    }
}
