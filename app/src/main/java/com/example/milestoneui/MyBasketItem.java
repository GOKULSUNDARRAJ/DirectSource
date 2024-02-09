package com.example.milestoneui;
public class MyBasketItem {
    private String productName;
    private String productCode;
    private String productDetails;
    private int imageResourceId; // Resource ID of the image

    public MyBasketItem(String productName, String productCode, String productDetails, int imageResourceId) {
        this.productName = productName;
        this.productCode = productCode;
        this.productDetails = productDetails;
        this.imageResourceId = imageResourceId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
