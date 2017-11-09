package com.mohan.indicator.ribbon;

/**
 * Created by mohang on 9/11/17.
 */

public class Item {

    private int image;
    private String name;
    private String ribbonText;

    public Item(int image, String name, String ribbonText) {
        this.image = image;
        this.name = name;
        this.ribbonText = ribbonText;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getRibbonText() {
        return ribbonText;
    }
}
