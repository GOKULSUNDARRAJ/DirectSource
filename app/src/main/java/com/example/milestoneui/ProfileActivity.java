package com.example.milestoneui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ProfileActivity extends AppCompatActivity {

    LinearLayout savedaddress,edit,offers123,fav;
    androidx.constraintlayout.widget.ConstraintLayout reset;


    ImageView back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToHome();
            }
        });

        offers123=findViewById(R.id.gotooffer);
        offers123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDealsFragment newFragment = new MyDealsFragment();
                Bundle args = new Bundle();
                args.putBoolean("fromProfileActivity", true); // Passing the flag
                newFragment.setArguments(args);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        reset=findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), ResetPassActivity.class);
                startActivity(intent);
            }
        });



        fav=findViewById(R.id.fav123);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoriteFragment newFragment = new FavoriteFragment();
                Bundle args = new Bundle();
                args.putBoolean("fromProfileActivity", true); // Passing the flag
                newFragment.setArguments(args);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });










        savedaddress=findViewById(R.id.savedaddress);
        savedaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),SavedAddressActivity.class));

            }
        });

        edit=findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),EditProfileActivity.class));
            }
        });

    }



    public void gotomydealf(View view) {

        MyDealsFragment newFragment = new MyDealsFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(android.R.id.content, newFragment);


        transaction.addToBackStack(null);


        transaction.commit();
    }



    public void gotonoti(View view) {
        startActivity(new Intent(ProfileActivity.this,Notification.class));
    }

    public void gotomyorder(View view) {
        startActivity(new Intent(ProfileActivity.this,MyOrderActivity.class));
    }



    private void navigateToHome() {
        // Since HomeActivity is a fragment, we don't navigate to it directly,
        // but we set a flag indicating that we want to navigate to the home fragment
        Intent intent = new Intent();
        intent.putExtra("navigate_to_home", true);
        setResult(RESULT_OK, intent);
        finish(); // Close the current activity
    }

}


