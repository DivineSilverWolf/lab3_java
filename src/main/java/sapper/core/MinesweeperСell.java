package sapper.core;

import javafx.scene.image.ImageView;

public class MinesweeperСell {
    private ImageView flagImage;
    private Boolean flag; //флаг
    private Boolean visibility;
    private Integer numberOrMine; // -1 = Mine; 0-8 = mines around the cell

    public MinesweeperСell(Boolean flag, Boolean visibility, Integer numberOrMine) {
        this.flag = flag;
        this.visibility = visibility;
        this.numberOrMine = numberOrMine;

    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    public Integer getNumberOrMine() {
        return numberOrMine;
    }

    public ImageView getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(ImageView flagImage) {
        this.flagImage = flagImage;
    }

    public void setNumberOrMine(Integer numberOrMine) {
        this.numberOrMine = numberOrMine;
    }
}
