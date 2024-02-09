package com.example.milestoneui;

public class FilterItem3 {
    private String name;
    private boolean isSelected;

    public FilterItem3(String name) {
        this.name = name;
        this.isSelected = false; // Initialize as not selected
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
