package sapper.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CurrentSettingsCopier {
    private static int SIZE_ELEMENT = 8;
    private static int NAME = 7;
    private static int STAGE_SIZE_X = 0;
    private static int STAGE_SIZE_Y = 1;
    private static int Xn = 2;
    private static int Yn = 3;
    private static int MINES = 4;
    private static int ATTEMPTS = 5;
    private static int LEVEL_ID = 6;
    private static String FILE_NAME = "..\\lab3Java\\Settings\\current settings";
    public static String[] copyCurrentSettings(){
        StringBuilder settingText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String string = reader.readLine();
            while (string != null) {
                settingText.append(string).append(" ");
                string = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] data=new String[SIZE_ELEMENT];
        data[NAME] = "";
        String[] settingsHandler = settingText.toString().trim().split(" ");
        for(int i=0; i<settingsHandler.length; i++){
            switch (settingsHandler[i]){
                case "StageSizeX":
                    data[STAGE_SIZE_X] = settingsHandler[++i];
                    break;
                case "StageSizeY":
                    data[STAGE_SIZE_Y] = settingsHandler[++i];
                    break;
                case "Xn":
                    data[Xn] = settingsHandler[++i];
                    break;
                case "Yn":
                    data[Yn] = settingsHandler[++i];
                    break;
                case "SizeMines":
                    data[MINES] = settingsHandler[++i];
                    break;
                case "SizeAttempts":
                    data[ATTEMPTS] = settingsHandler[++i];
                    break;
                case "LevelID":
                    data[LEVEL_ID] = settingsHandler[++i];
                    break;
                case "Name":
                    ++i;
                    for(int j=i; j<settingsHandler.length; j++) {
                        i=j;
                        data[NAME] += settingsHandler[j] + " ";
                        break;
                    }
            }
        }
        return data;
    }
}
