package com.example.milestoneui;
public class MyDataModel {
    private String orderID;
    private int quantity;
    private String price;
    private int imageResourceId; // Drawable resource ID

    public MyDataModel(String orderID, int quantity, String price, int imageResourceId) {
        this.orderID = orderID;
        this.quantity = quantity;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
