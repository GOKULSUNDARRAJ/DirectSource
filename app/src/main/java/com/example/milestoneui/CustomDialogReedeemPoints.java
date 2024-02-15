package com.example.milestoneui;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CustomDialogReedeemPoints extends Dialog {




    public CustomDialogReedeemPoints(@NonNull Context context) {
        super(context);
    }



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_book_slot);


        Button continuebtn=findViewById(R.id.continu);
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              dismiss();
            }
        });

    }
    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        return true;
    }

    @Override
    public void onBackPressed() {

    }
}
