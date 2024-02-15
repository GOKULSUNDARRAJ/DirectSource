package com.example.milestoneui;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("appLogin")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);


    @POST("register")
    Call<RegistrationResponse> register(@Body RegistrationRequest request);

    @GET("checkMobileExistence")
    Call<ExistenceResponse> checkMobileExistence(@Query("mobile") String mobile);

    @GET("checkEmailExistence")
    Call<ExistenceResponse> checkEmailExistence(@Query("email") String email);


}
