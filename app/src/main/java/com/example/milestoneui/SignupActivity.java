package com.example.milestoneui;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupActivity extends AppCompatActivity {

    EditText Bname, BownerName, Pnumber, Email, DoorNo, StreetNo, CityNo, PostCode;
    Button signupButton;
    private Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Bname = findViewById(R.id.bnameed);
        BownerName = findViewById(R.id.bownernameed);
        Pnumber = findViewById(R.id.phoneed);
        Email = findViewById(R.id.emailed);
        DoorNo = findViewById(R.id.doornoed);
        StreetNo = findViewById(R.id.StreetNameed);
        CityNo = findViewById(R.id.citynameed);
        PostCode = findViewById(R.id.pincodeed);
        signupButton = findViewById(R.id.login);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String businessName = Bname.getText().toString().trim();
                String ownerName = BownerName.getText().toString().trim();
                String phoneNumber = Pnumber.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String doorNo = DoorNo.getText().toString().trim();
                String streetNo = StreetNo.getText().toString().trim();
                String city = CityNo.getText().toString().trim();
                String postCode = PostCode.getText().toString().trim();


                if (businessName.isEmpty() || ownerName.isEmpty() || phoneNumber.isEmpty() ||
                        email.isEmpty() || doorNo.isEmpty() || streetNo.isEmpty() ||
                        city.isEmpty() || postCode.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {


                }
            }
        });

    }



}
