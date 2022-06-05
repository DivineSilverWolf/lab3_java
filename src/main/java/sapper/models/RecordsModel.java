package sapper.models;

import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RecordsModel {
    private final static String FILE_NAME = "..\\lab3Java\\Ratings\\";

    public static void readFile(TextField[] textFields, String levelID) {
        for (int i = 0; i < textFields.length; i++)
            textFields[i].setText("");


        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME + levelID))) {
            String string = reader.readLine();
            int count = 0;
            while (string != null && count < textFields.length) {
                if (!string.equals("")) {
                    textFields[count++].setText(string);
                }
                string = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
