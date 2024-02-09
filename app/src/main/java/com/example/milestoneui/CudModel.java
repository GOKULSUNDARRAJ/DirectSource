package com.example.milestoneui;
public class CudModel {
    private String orderID;
    private String orderDate;
    private String status;
    private String price;
    private int imageResourceId; // Change the type to int for drawable resource ID

    public CudModel(String orderID, String orderDate, String status, String price, int imageResourceId) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.status = status;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
