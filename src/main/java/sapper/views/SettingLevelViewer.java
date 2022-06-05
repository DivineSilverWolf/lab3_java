package sapper.views;

import sapper.contexts.ContextSetting;

public class SettingLevelViewer {
    /*здесь не делал констант, потому что очевидно мы, к примеру,
    соотносим для StageSizeX из contextSetting
    настройки из "StageSizeX"
     */
    public static void settingLevelView(String settingText, ContextSetting contextSetting){
        String[] settingsHandler = settingText.trim().split(" ");
        for(int i=0; i<settingsHandler.length; i++){
            switch (settingsHandler[i]){
                case "StageSizeX":
                    contextSetting.getStageSizeX().setText(settingsHandler[++i]);
                    break;
                case "StageSizeY":
                    contextSetting.getStageSizeY().setText(settingsHandler[++i]);
                    break;
                case "Xn":
                    contextSetting.getXn().setText(settingsHandler[++i]);
                    break;
                case "Yn":
                    contextSetting.getYn().setText(settingsHandler[++i]);
                    break;
                case "SizeMines":
                    contextSetting.getSizeMines().setText(settingsHandler[++i]);
                    break;
                case "SizeAttempts":
                    contextSetting.getSizeAttempts().setText(settingsHandler[++i]);
                    break;
                case "LevelID":
                    contextSetting.getLevelID().set(settingsHandler[++i]);
                    break;
            }
        }
        contextSetting.getSizeCell().setText(Integer.parseInt(contextSetting.getXn().getText()) * Integer.parseInt(contextSetting.getYn().getText()) + "");
    }
    public static void settingSetDisableOrAllowInput(ContextSetting contextSetting, final boolean Input){
        contextSetting.getXn().setEditable(Input);
        contextSetting.getYn().setEditable(Input);
        contextSetting.getSizeMines().setEditable(Input);
        contextSetting.getSizeAttempts().setEditable(Input);
    }
}
