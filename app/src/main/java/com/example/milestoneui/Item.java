package com.example.milestoneui;
public class Item {
    private int imageResource;
    private String text;

    public Item(int imageResource, String text) {
        this.imageResource = imageResource;
        this.text = text;
    }

    public Item() {
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }
}
