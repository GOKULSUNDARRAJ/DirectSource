package com.example.milestoneui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Notification extends AppCompatActivity {
    private RecyclerView recyclerView,recyclerView2;
    private NotificationAdapter adapter;
    private List<NotificationItem> itemList;
    private List<NotificationItem2> itemList2;
    private NotificationAdapter2 adapter2;
    TextView textView17,textView7;

    LinearLayout recentLinearLayout,linearLayout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        textView17=findViewById(R.id.textView17);
        textView7=findViewById(R.id.textView7);

        ImageView goToHomeButton;
        goToHomeButton = findViewById(R.id.back);
        goToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHome();
            }
        });

        recentLinearLayout=findViewById(R.id.recent);
        linearLayout=findViewById(R.id.linearLayout);

        recentLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change background drawable when clicked
                recentLinearLayout.setBackgroundResource(R.drawable.redline1);
                textView17.setTextColor(Color.RED);

                recyclerView.setVisibility(View.GONE);
                linearLayout.setBackgroundResource(R.drawable.grayline123);
                textView7.setTextColor(Color.GRAY);
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change background drawable when clicked
                recentLinearLayout.setBackgroundResource(R.drawable.grayline123);
                textView17.setTextColor(Color.GRAY);

                recyclerView.setVisibility(View.VISIBLE);
                linearLayout.setBackgroundResource(R.drawable.redline1);
                textView7.setTextColor(Color.RED);
            }
        });


        // Initialize RecyclerView and item list
        recyclerView = findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();

        // Dummy data for demonstration
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.co2));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.cleningas));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.carrybags));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.sause));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.chuttny));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.containers));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.co2));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.cleningas));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.carrybags));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.sause));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.chuttny));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.containers));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.co2));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.cleningas));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.carrybags));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.sause));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.chuttny));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.containers));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.co2));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.cleningas));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.carrybags));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.sause));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.chuttny));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.containers));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.co2));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.cleningas));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.carrybags));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.sause));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.chuttny));
        itemList.add(new NotificationItem("EXTRA 4 OFF", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.containers));


        // Initialize adapter and set it to RecyclerView
        adapter = new NotificationAdapter(itemList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);



        // Initialize RecyclerView and item list
        recyclerView2 = findViewById(R.id.recyclerView2);
        itemList2 = new ArrayList<>();

        // Dummy data for demonstration
        itemList2.add(new NotificationItem2("Order #242334623452F ha successfull", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Thank you your Transaction is Completed", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Order #242334623452F ha Cancelled", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Thank you your Transaction is Failed", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Order #242334623452F ha Cancelled", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Thank you your Transaction is Failed", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Order #242334623452F ha successfull", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Thank you your Transaction is Completed", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Order #242334623452F ha successfull", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Thank you your Transaction is Completed", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Order #242334623452F ha Cancelled", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Thank you your Transaction is Failed", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Order #242334623452F ha Cancelled", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Thank you your Transaction is Failed", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Order #242334623452F ha successfull", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Thank you your Transaction is Completed", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));
        itemList2.add(new NotificationItem2("Order #242334623452F ha successfull", "Description 3 Aunt Bessies yorhire Pudin 1x60", R.drawable.profile2));



        // Initialize adapter and set it to RecyclerView
        adapter2 = new NotificationAdapter2(itemList2, this);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView2.setAdapter(adapter2);
    }

    private void navigateToHome() {

        Intent intent = new Intent();
        intent.putExtra("navigate_to_home", true);
        setResult(RESULT_OK, intent);
        finish();
    }
}
