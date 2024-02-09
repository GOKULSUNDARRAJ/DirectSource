package com.example.milestoneui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class BrowseFragment extends Fragment {

    private ItemAdapter adapter;
    private RecyclerView recyclerView;


    private RecyclerView recyclerView2;


    private Button filter, sortbtn;
    TextView textView;


    List<Item> itemList;
    androidx.constraintlayout.widget.ConstraintLayout cart;


    private BrowseAdapter listProductAdapter;
    private BrowseAdapter2 gridProductAdapter;
    List<BrowseItem> itemList2;
    Button listbtn;
    boolean isListView = false;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_browse, container, false);

       ImageView  Image=view.findViewById(R.id.Image);

        Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AllCategoriesFragment fragmentB = new AllCategoriesFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });



        recyclerView = view.findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);


        itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.pro1, "Item 1"));
        itemList.add(new Item(R.drawable.pro1, "Item 2"));
        itemList.add(new Item(R.drawable.pro1, "Item 3"));
        itemList.add(new Item(R.drawable.pro1, "Item 2"));
        itemList.add(new Item(R.drawable.pro1, "Item 3"));
        itemList.add(new Item(R.drawable.pro1, "Item 2"));
        itemList.add(new Item(R.drawable.pro1, "Item 3"));
        itemList.add(new Item(R.drawable.pro1, "Item 2"));
        itemList.add(new Item(R.drawable.pro1, "Item 3"));
        itemList.add(new Item(R.drawable.pro1, "Item 2"));
        itemList.add(new Item(R.drawable.pro1, "Item 3"));
        itemList.add(new Item(R.drawable.pro1, "Item 2"));
        itemList.add(new Item(R.drawable.pro1, "Item 3"));
        itemList.add(new Item(R.drawable.pro1, "Item 2"));
        itemList.add(new Item(R.drawable.pro1, "Item 3"));


        adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);

        itemList2 = new ArrayList<>();
        listbtn = view.findViewById(R.id.button387);
        recyclerView2=view.findViewById(R.id.recyclerView);

        listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isListView = !isListView;
                if (isListView) {
                    recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView2.setAdapter(listProductAdapter);
                } else {
                    recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    recyclerView2.setAdapter(gridProductAdapter);
                }
            }
        });

        ImageView goToNewActivityButton = view.findViewById(R.id.back);
        goToNewActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment fragmentB = new ProfileFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        Bundle bundle = getArguments();
        if (bundle != null) {
            String selectedItems = bundle.getString("selectedItems", "");
            // Do something with the selectedItems string, such as displaying it in a TextView
            textView = view.findViewById(R.id.title);
            textView.setText(selectedItems);
        }


        filter = view.findViewById(R.id.button3);
        sortbtn = view.findViewById(R.id.button33);

        cart = view.findViewById(R.id.cart123);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyBasketActivity.class));
            }
        });


        sortbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.sortby);


                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM);
            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilterFragment  fragmentB = new FilterFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        populateDummyData();


        gridProductAdapter = new BrowseAdapter2(getContext(), itemList2);

        listProductAdapter = new BrowseAdapter(getContext(),itemList2);

        recyclerView2.setAdapter(gridProductAdapter);
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 2));

        try {
            flter();
        }catch (Exception e){

        }

        return view;
    }

    private void flter() {
        String searchText = textView.getText().toString().trim();


        List<BrowseItem> filteredItemList = new ArrayList<>();
        for (BrowseItem item : itemList2) {
            if (item.getTitle().equalsIgnoreCase(searchText)) {
                filteredItemList.add(item);
            }else {

            }
        }


        listProductAdapter.setItems(filteredItemList);
        listProductAdapter.notifyDataSetChanged();

        gridProductAdapter.setItems(filteredItemList);
        gridProductAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        showBottomNavigation();
    }

    @Override
    public void onPause() {
        super.onPause();
        hideBottomNavigation();
    }

    private void showBottomNavigation() {
        if (getActivity() != null) {
            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
            if (bottomNavigationView != null) {
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        }
    }

    private void hideBottomNavigation() {
        if (getActivity() != null) {
            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
            if (bottomNavigationView != null) {
                bottomNavigationView.setVisibility(View.GONE);
            }
        }
    }



    private void populateDummyData() {
        itemList2.add(new BrowseItem(R.drawable.checken, "Poultry"));
        itemList2.add(new BrowseItem(R.drawable.oil, "Oils Fats"));
        itemList2.add(new BrowseItem(R.drawable.carrybags, "Bag"));
        itemList2.add(new BrowseItem(R.drawable.co2, "Drinks"));
        itemList2.add(new BrowseItem(R.drawable.pizza, "Pizza"));
        itemList2.add(new BrowseItem(R.drawable.cleningas, "Cleanings"));
        itemList2.add(new BrowseItem(R.drawable.oil, "Oils Fats"));
        itemList2.add(new BrowseItem(R.drawable.carrybags, "Bag"));
        itemList2.add(new BrowseItem(R.drawable.co2, "Brand2"));
        itemList2.add(new BrowseItem(R.drawable.carrybags, "Bag"));
        itemList2.add(new BrowseItem(R.drawable.co2, "Drinks"));
        itemList2.add(new BrowseItem(R.drawable.cleningas, "Cleanings"));
        itemList2.add(new BrowseItem(R.drawable.oil, "Oils Fats"));
        itemList2.add(new BrowseItem(R.drawable.carrybags, "Bag"));
        itemList2.add(new BrowseItem(R.drawable.co2, "Offers"));
        itemList2.add(new BrowseItem(R.drawable.pizza, "Pizza"));
        itemList2.add(new BrowseItem(R.drawable.cleningas, "Cleanings"));
        itemList2.add(new BrowseItem(R.drawable.oil, "Oils Fats"));
        itemList2.add(new BrowseItem(R.drawable.carrybags, "Bag"));
        itemList2.add(new BrowseItem(R.drawable.co2, "Drinks"));
        itemList2.add(new BrowseItem(R.drawable.pizza, "Pizza"));
        itemList2.add(new BrowseItem(R.drawable.cleningas, "Cleanings"));
        itemList2.add(new BrowseItem(R.drawable.oil, "Oils Fats"));
        itemList2.add(new BrowseItem(R.drawable.carrybags, "Bag"));
        itemList2.add(new BrowseItem(R.drawable.co2, "Drinks"));
        itemList2.add(new BrowseItem(R.drawable.carrybags, "Bag"));
        itemList2.add(new BrowseItem(R.drawable.co2, "Drinks"));
        itemList2.add(new BrowseItem(R.drawable.cleningas, "Cleanings"));
        itemList2.add(new BrowseItem(R.drawable.oil, "Oils Fats"));
        itemList2.add(new BrowseItem(R.drawable.carrybags, "Bag"));
        itemList2.add(new BrowseItem(R.drawable.co2, "offers"));

    }




}
