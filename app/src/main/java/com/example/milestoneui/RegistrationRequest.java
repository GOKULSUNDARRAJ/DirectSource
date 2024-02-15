package com.example.milestoneui;

public class RegistrationRequest {
    private String email;
    private String businessName;
    private String ownerName;
    private String phoneNumber;
    private String doorNo;
    private String streetNo;
    private String city;
    private String postCode;

    public RegistrationRequest(String email, String businessName, String ownerName, String phoneNumber, String doorNo, String streetNo, String city, String postCode) {
        this.email = email;
        this.businessName = businessName;
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
        this.doorNo = doorNo;
        this.streetNo = streetNo;
        this.city = city;
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
