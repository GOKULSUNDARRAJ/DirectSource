package com.example.milestoneui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class swapdialog extends Dialog {

    private RecyclerView.Adapter adapter;
    private List<SwapItem> itemList;

    public swapdialog(@NonNull Context context, List<SwapItem> itemList) {
        super(context);
        this.itemList = itemList;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogreedeem);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60", R.drawable.checken));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60", R.drawable.co2));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.sause));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.ser));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.co2));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.carrybags));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.carrybags));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.chuttny));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60", R.drawable.co2));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.sause));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.ser));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.co2));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.co2));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.carrybags));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.carrybags));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.chuttny));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60", R.drawable.co2));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.sause));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.ser));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.co2));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.carrybags));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.chuttny));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60", R.drawable.co2));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.sause));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.ser));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.co2));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.co2));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.carrybags));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.carrybags));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.chuttny));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60", R.drawable.co2));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.sause));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.ser));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.co2));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.carrybags));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.carrybags));
        itemList.add(new SwapItem("Lion Quality Medium Eggs-(size 3)-1x60",R.drawable.chuttny));


        adapter = new SwapAdapter(getContext(), itemList);
        recyclerView.setAdapter(adapter);


    }



    @Override
    public void onBackPressed() {

    }
}
