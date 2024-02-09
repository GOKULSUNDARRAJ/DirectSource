package com.example.milestoneui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyOrderActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private List<CudModel> dataList;

    ImageView filterbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        filterbtn=findViewById(R.id.textView17);

        filterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });


        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Prepare data
        dataList = prepareData();

        // Initialize adapter
        adapter = new CustomAdapter(this, dataList);

        // Set adapter on RecyclerView
        recyclerView.setAdapter(adapter);
    }

    private List<CudModel> prepareData() {
        // Here you would typically fetch data from your database or server
        // For this example, let's create dummy data
        List<CudModel> data = new ArrayList<>();
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.productimage));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.checken));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.cleningas));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.sause));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.productimage));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.pizza));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.productimage));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.checken));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.cleningas));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.sause));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.productimage));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.pizza));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.pizza));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.productimage));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.checken));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.cleningas));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.sause));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.productimage));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.pizza));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.productimage));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.checken));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.cleningas));
        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.sause));

        data.add(new CudModel("ID0D76345355", "Oct 19", "Processing", "£38.49", R.drawable.bun));


        // Add more items as needed
        return data;
    }


    private void showDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.filterbottom);

        LinearLayout linearLayout15=dialog.findViewById(R.id.linearLayout15);

        linearLayout15.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                linearLayout15.setBackgroundResource(R.drawable.bluelineround);


            }
        });

        LinearLayout linearLayout16=dialog.findViewById(R.id.linearLayout16);
        linearLayout16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout16.setBackgroundResource(R.drawable.bluelineround);
            }
        });

        LinearLayout linear17=dialog.findViewById(R.id.linear17);
        linear17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear17.setBackgroundResource(R.drawable.bluelineround);
            }
        });
        LinearLayout linearLayout17=dialog.findViewById(R.id.linearLayout17);

        linearLayout17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout17.setBackgroundResource(R.drawable.bluelineround);
            }
        });


        LinearLayout linearLayout18=dialog.findViewById(R.id.linearLayout18);

        linearLayout18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout18.setBackgroundResource(R.drawable.bluelineround);
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}
