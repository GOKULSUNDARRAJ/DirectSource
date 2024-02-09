package com.example.milestoneui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToHome();
            }
        });


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