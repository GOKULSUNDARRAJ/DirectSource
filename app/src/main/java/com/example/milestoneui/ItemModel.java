package com.example.milestoneui;

public class ItemModel {
    private int imageResource;
    private String itemName;
    private boolean isSelected;

    public ItemModel(int imageResource, String itemName) {
        this.imageResource = imageResource;
        this.itemName = itemName;
        this.isSelected = false; // Initialize as not selected
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
