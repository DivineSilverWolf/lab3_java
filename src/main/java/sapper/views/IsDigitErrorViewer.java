package sapper.views;

import javafx.scene.text.Text;

public class IsDigitErrorViewer {
    final static String ERROR_TEXT_1 = "sizeX<X:";
    final static String ERROR_TEXT_2 = "sizeY<Y:";
    final static String FORMAT = "%.2f";
    final static String MORE_THAN = "<";
    final static String ENUMERATION = " ; ";

    public static boolean isDigitErrorView(Text text, double SizeX, double SizeY, final double x, final double y, String XY, String X, String Y) {
        if (SizeX < x && SizeY < y) {
            String sizeX = String.format(FORMAT, SizeX);
            String sizeY = String.format(FORMAT, SizeY);

            text.setText(ERROR_TEXT_1 + sizeX + MORE_THAN + Math.round(x) + ENUMERATION + ERROR_TEXT_2 + sizeY + MORE_THAN + Math.round(y));
            return false;
        } else if (SizeX < x && SizeY >= y) {
            String sizeX = String.format(FORMAT, SizeX);
            text.setText(ERROR_TEXT_1 + sizeX + MORE_THAN + Math.round(x));
            System.out.println(SizeX + " " + x);
            return false;
        } else if (SizeX >= x && SizeY < y) {
            String sizeY = String.format(FORMAT, SizeY);
            text.setText(ERROR_TEXT_2 + sizeY + MORE_THAN + Math.round(y));
            return false;
        }
        text.setText("");
        return true;
    }
}
