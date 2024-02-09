package com.example.milestoneui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    EditText Bname, BownerName, Pnumber, Email, DoorNo, StreerNo, CityNo, PostCode;
    Button Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Bname = findViewById(R.id.bnameed);
        BownerName = findViewById(R.id.bownernameed);
        Pnumber = findViewById(R.id.phoneed);
        Email = findViewById(R.id.emailed);
        DoorNo = findViewById(R.id.doornoed);
        StreerNo = findViewById(R.id.StreetNameed);
        CityNo = findViewById(R.id.citynameed);
        PostCode = findViewById(R.id.pincodeed);

        Signup = findViewById(R.id.login);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Bname1 = Bname.getText().toString();
                String BownerName1 = BownerName.getText().toString();
                String Pnumber1 = Pnumber.getText().toString();
                String Email1 = Email.getText().toString();
                String DoorNo1 = DoorNo.getText().toString();
                String StreerNo1 = StreerNo.getText().toString();
                String CityNo1 = CityNo.getText().toString();
                String PostCode1 = PostCode.getText().toString();


                if (Bname1.isEmpty()) {
                    Bname.setError("Field is Required");
                } else if (BownerName1.isEmpty()) {
                    BownerName.setError("Field is Required");
                } else if (Pnumber1.isEmpty()) {
                    Pnumber.setError("Field is Required");
                } else if (Email1.isEmpty()) {
                    Email.setError("Field is Required");
                } else if (DoorNo1.isEmpty()) {
                    DoorNo.setError("Field is Required");
                } else if (StreerNo1.isEmpty()) {
                    StreerNo.setError("Field is Required");
                } else if (CityNo1.isEmpty()) {
                    CityNo.setError("Field is Required");
                } else if (PostCode1.isEmpty()) {
                    PostCode.setError("Field is Required");
                } else {
                    showCustomDialog();

                }
            }
        });


    }


    public void gotodialog(View view) {
        showCustomDialog();
    }

    private void showCustomDialog() {
        CustomDialogClassfoeadd cdd = new CustomDialogClassfoeadd(this);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
    }
}