package com.example.milestoneui;

public class SwapItem {
    private String itemText;
    private int imageResource;

    public SwapItem(String itemText, int imageResource) {
        this.itemText = itemText;
        this.imageResource = imageResource;
    }

    public String getItemText() {
        return itemText;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
