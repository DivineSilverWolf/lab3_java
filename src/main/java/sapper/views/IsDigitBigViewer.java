package sapper.views;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class IsDigitBigViewer {
    final static String ERROR_TEXT = "число(а) слишком большое(ие): ";

    public static boolean isDigitBigView(Text text, TextField SizeX, TextField SizeY, final double x, final double y, String XY, String X, String Y) {
        if (Integer.parseInt(SizeX.getText()) > x && Integer.parseInt(SizeY.getText()) > y) {
            text.setText(ERROR_TEXT + XY);
            return false;
        } else if (Integer.parseInt(SizeX.getText()) > x && Integer.parseInt(SizeY.getText()) <= y) {
            text.setText(ERROR_TEXT + X);
            return false;
        } else if (Integer.parseInt(SizeX.getText()) <= x && Integer.parseInt(SizeY.getText()) > y) {
            text.setText(ERROR_TEXT + Y);
            return false;
        }
        text.setText("");
        return true;
    }
}
