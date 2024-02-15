package com.example.milestoneui;

public class MItem {
    private String text;
    private int imageResourceId;

    public MItem(String text, int imageResourceId) {
        this.text = text;
        this.imageResourceId = imageResourceId;
    }

    public String getText() {
        return text;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
