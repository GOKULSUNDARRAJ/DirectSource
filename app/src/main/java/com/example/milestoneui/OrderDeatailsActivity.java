package com.example.milestoneui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class OrderDeatailsActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private MyCustomAdapter adapter;
    private List<MyDataModel> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_deatails);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataList = new ArrayList<>();


        dataList.add(new MyDataModel("Order ID;ODB346223522", 2, "$20.50", R.drawable.checken));
        dataList.add(new MyDataModel("Order ID;ODB346223522", 1, "$15.99", R.drawable.co1));
        dataList.add(new MyDataModel("ID2Order ID;ODB346223522", 1, "$15.99", R.drawable.cleningas));
        dataList.add(new MyDataModel("ID2Order ID;ODB346223522", 1, "$15.99", R.drawable.sause));
        dataList.add(new MyDataModel("Order ID;ODB346223522", 2, "$20.50", R.drawable.checken));
        dataList.add(new MyDataModel("Order ID;ODB346223522", 2, "$20.50", R.drawable.checken));
        dataList.add(new MyDataModel("Order ID;ODB346223522", 1, "$15.99", R.drawable.co1));
        dataList.add(new MyDataModel("ID2Order ID;ODB346223522", 1, "$15.99", R.drawable.cleningas));
        dataList.add(new MyDataModel("ID2Order ID;ODB346223522", 1, "$15.99", R.drawable.sause));
        dataList.add(new MyDataModel("Order ID;ODB346223522", 2, "$20.50", R.drawable.checken));dataList.add(new MyDataModel("Order ID;ODB346223522", 2, "$20.50", R.drawable.checken));
        dataList.add(new MyDataModel("Order ID;ODB346223522", 1, "$15.99", R.drawable.co1));
        dataList.add(new MyDataModel("ID2Order ID;ODB346223522", 1, "$15.99", R.drawable.cleningas));
        dataList.add(new MyDataModel("ID2Order ID;ODB346223522", 1, "$15.99", R.drawable.sause));
        dataList.add(new MyDataModel("Order ID;ODB346223522", 2, "$20.50", R.drawable.checken));dataList.add(new MyDataModel("Order ID;ODB346223522", 2, "$20.50", R.drawable.checken));
        dataList.add(new MyDataModel("Order ID;ODB346223522", 1, "$15.99", R.drawable.co1));
        dataList.add(new MyDataModel("ID2Order ID;ODB346223522", 1, "$15.99", R.drawable.cleningas));
        dataList.add(new MyDataModel("ID2Order ID;ODB346223522", 1, "$15.99", R.drawable.sause));
        dataList.add(new MyDataModel("Order ID;ODB346223522", 2, "$20.50", R.drawable.checken));





        adapter = new MyCustomAdapter(this, dataList);
        recyclerView.setAdapter(adapter);
    }
}