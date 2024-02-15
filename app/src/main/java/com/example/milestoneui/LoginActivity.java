package com.example.milestoneui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {


    EditText emailEditText;
    EditText passwordEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailedt);
        passwordEditText = findViewById(R.id.passdt);
        loginButton = findViewById(R.id.login);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://staging-ddpoints.mydd.app/ds_customer/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiService apiService = retrofit.create(ApiService.class);

                LoginRequest loginRequest = new LoginRequest("DS_APP", email, password, "DBB8582E-E4F6-4BB7-8FE4-809FD1FB4900", "", "A", "");

                Call<LoginResponse> call = apiService.login(loginRequest);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            LoginResponse loginResponse = response.body();
                            boolean status = loginResponse.isStatus();
                            String message = loginResponse.getMessage();

                            if (status) {

                                String userEmail = emailEditText.getText().toString().trim();

                                String registeredEmail = loginResponse.getResponse().getEmail();

                                if (userEmail.equals(registeredEmail)) {

                                    String customerId = String.valueOf(loginResponse.getResponse().getCustomerId());
                                    String companyName = loginResponse.getResponse().getCompanyName();
                                    String accessToken = loginResponse.getResponse().getAccessToken();

                                    Toast.makeText(LoginActivity.this, "You are successfully registered: " + customerId, Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(v.getContext(),MainActivity.class));

                                } else {

                                    Toast.makeText(LoginActivity.this, "Invalid email", Toast.LENGTH_SHORT).show();
                                }
                            } else {

                                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                        Toast.makeText(LoginActivity.this, "Login failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    public void gotocreateActivity(View view) {
        startActivity(new Intent(view.getContext(),SignupActivity.class));
    }



}
