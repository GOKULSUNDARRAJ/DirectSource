package com.example.milestoneui;

public class CommonModel {
    private String itemText;
    private int imageResource;

    public CommonModel(String itemText, int imageResource) {
        this.itemText = itemText;
        this.imageResource = imageResource;
    }

    public String getItemText() {
        return itemText;
    }

    public int getImageResource() {
        return imageResource;
    }
}
