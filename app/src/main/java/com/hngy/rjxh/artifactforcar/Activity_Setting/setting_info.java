package com.hngy.rjxh.artifactforcar.Activity_Setting;

/**
 * Created by 57677 on 2018/6/28.
 */

public class setting_info {
    private String text;
    private int Image;

    public setting_info(String text, int image) {
        this.text = text;
        Image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
