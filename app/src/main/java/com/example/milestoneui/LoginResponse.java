package com.example.milestoneui;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("response")
    private ResponseData response;

    @SerializedName("message")
    private String message;

    @SerializedName("error_type")
    private String errorType;

    @SerializedName("status")
    private boolean status;

    public ResponseData getResponse() {
        return response;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorType() {
        return errorType;
    }

    public boolean isStatus() {
        return status;
    }

    public class ResponseData {
        @SerializedName("customer_id")
        private int customerId;

        @SerializedName("company_name")
        private String companyName;

        @SerializedName("customer_code")
        private String customerCode;

        @SerializedName("contact_name")
        private String contactName;

        @SerializedName("loyalty")
        private int loyalty;

        @SerializedName("email")
        private String email;

        @SerializedName("mobile")
        private String mobile;

        @SerializedName("user_succ")
        private String userSucc;

        @SerializedName("token_type")
        private String tokenType;

        @SerializedName("expires_in")
        private int expiresIn;

        @SerializedName("access_token")
        private String accessToken;

        @SerializedName("refresh_token")
        private String refreshToken;

        public int getCustomerId() {
            return customerId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public String getCustomerCode() {
            return customerCode;
        }

        public String getContactName() {
            return contactName;
        }

        public int getLoyalty() {
            return loyalty;
        }

        public String getEmail() {
            return email;
        }

        public String getMobile() {
            return mobile;
        }

        public String getUserSucc() {
            return userSucc;
        }

        public String getTokenType() {
            return tokenType;
        }

        public int getExpiresIn() {
            return expiresIn;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }
    }
}
