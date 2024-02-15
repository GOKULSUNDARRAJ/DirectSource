package com.example.milestoneui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class CheckOutActivity extends AppCompatActivity {

    TextView btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);


        RadioButton radioButton = findViewById(R.id.notification);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout savedAddView = findViewById(R.id.savedaddree1);
        LinearLayout savedAddView2 = findViewById(R.id.savedaddress);

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    savedAddView.setVisibility(View.VISIBLE);
                    savedAddView2.setVisibility(View.VISIBLE);
                } else {
                    savedAddView.setVisibility(View.GONE);
                    savedAddView2.setVisibility(View.GONE);
                }
            }
        });




        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
    }


    private void showCustomDialog() {
        CustomDialogClassbookyourslot cdd = new CustomDialogClassbookyourslot(this);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
    }




    public void showCustomDialogRedeem(View view) {
        CustomDialogReedeemPoints cdd = new CustomDialogReedeemPoints(this);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
    }


    public void showCustomDialopay(View view) {
        paymentFailed cdd = new paymentFailed(this);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
    }
}