package com.example.milestoneui;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("client_id")
    private String clientId;

    @SerializedName("userEmail")
    private String userEmail;

    @SerializedName("password")
    private String password;

    @SerializedName("deviceID")
    private String deviceId;

    @SerializedName("device_token")
    private String deviceToken;

    @SerializedName("mobileType")
    private String mobileType;

    @SerializedName("device_mode")
    private String deviceMode;

    public LoginRequest(String clientId, String userEmail, String password, String deviceId, String deviceToken, String mobileType, String deviceMode) {
        this.clientId = clientId;
        this.userEmail = userEmail;
        this.password = password;
        this.deviceId = deviceId;
        this.deviceToken = deviceToken;
        this.mobileType = mobileType;
        this.deviceMode = deviceMode;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    public String getDeviceMode() {
        return deviceMode;
    }

    public void setDeviceMode(String deviceMode) {
        this.deviceMode = deviceMode;
    }
}
