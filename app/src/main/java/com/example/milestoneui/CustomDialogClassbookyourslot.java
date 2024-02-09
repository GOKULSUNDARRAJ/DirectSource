package com.example.milestoneui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class CustomDialogClassbookyourslot extends Dialog {

    private Context mContext;

    public CustomDialogClassbookyourslot(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_book_slot);

        CardView scancard = findViewById(R.id.scancard);
        scancard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Goto Browse Fragment", Toast.LENGTH_SHORT).show();
            }
        });

        RadioButton radio1 = findViewById(R.id.radio1);
        final TextView title7 = findViewById(R.id.title7);
        final EditText passdt8 = findViewById(R.id.passdt8);
        TextView title5 = findViewById(R.id.title5);
        TextView title10 = findViewById(R.id.title10);
        TextView title11 = findViewById(R.id.title11);
        TextView title3 = findViewById(R.id.title3);
        TextView title2 = findViewById(R.id.title2);
        TextView title33 = findViewById(R.id.title33);
        RadioButton radio2 = findViewById(R.id.radio2);
        TextView title20 = findViewById(R.id.title20);


        radio2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    radio1.setChecked(false); // Uncheck radio1
                    title7.setVisibility(View.VISIBLE);
                    passdt8.setVisibility(View.VISIBLE);
                    title20.setVisibility(View.GONE);
                    title11.setVisibility(View.GONE);
                    title3.setVisibility(View.VISIBLE);
                    title5.setVisibility(View.VISIBLE);
                    title10.setVisibility(View.GONE);
                    title2.setVisibility(View.VISIBLE);
                    title33.setVisibility(View.GONE);
                } else {
                    title7.setVisibility(View.GONE);
                    passdt8.setVisibility(View.GONE);
                    title20.setVisibility(View.VISIBLE);
                    title11.setVisibility(View.VISIBLE);
                    title3.setVisibility(View.GONE);
                    title5.setVisibility(View.GONE);
                    title2.setVisibility(View.GONE);
                    title33.setVisibility(View.VISIBLE);
                }
            }
        });

        radio1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    radio2.setChecked(false);
                    title7.setVisibility(View.GONE);
                    passdt8.setVisibility(View.GONE);
                    title10.setVisibility(View.VISIBLE);
                    title11.setVisibility(View.VISIBLE);
                    title2.setVisibility(View.GONE);
                    title3.setVisibility(View.GONE);
                    title33.setVisibility(View.VISIBLE);
                } else {
                    title7.setVisibility(View.VISIBLE);
                    passdt8.setVisibility(View.VISIBLE);
                    title10.setVisibility(View.GONE);
                    title11.setVisibility(View.GONE);
                    title3.setVisibility(View.VISIBLE);
                    title2.setVisibility(View.VISIBLE);
                    title33.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        return true;
    }


}
