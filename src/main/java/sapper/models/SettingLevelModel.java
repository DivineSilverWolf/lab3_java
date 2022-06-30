package sapper.models;

import sapper.contexts.ContextSetting;
import sapper.views.SettingLevelViewer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SettingLevelModel {
    private static final String FILE_NAME = "..\\lab3Java\\Settings\\";

    public static void setSettingsFromFile(ContextSetting contextSetting, String fileName) {
        StringBuilder settingText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME + fileName))) {
            String string = reader.readLine();
            while (string != null) {
                settingText.append(string).append(" ");
                string = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        SettingLevelViewer.settingLevelView(settingText.toString(), contextSetting);
    }

    public static void setLevelOrCustom(ContextSetting contextSetting, boolean Input) {
        SettingLevelViewer.settingSetDisableOrAllowInput(contextSetting, Input);
    }

    private static boolean SELECT = true;

    public static void selected(ContextSetting contextSetting) {
        if (contextSetting.getLevelID().get().equals(contextSetting.getLvlNumber1().getText()))
            contextSetting.getLvlNumber1().setSelected(SELECT);
        else if (contextSetting.getLevelID().get().equals(contextSetting.getLvlNumber2().getText()))
            contextSetting.getLvlNumber2().setSelected(SELECT);
        else if (contextSetting.getLevelID().get().equals(contextSetting.getLvlNumber3().getText()))
            contextSetting.getLvlNumber3().setSelected(SELECT);
        else
            contextSetting.getLvlNumberCustom().setSelected(SELECT);

    }

}
