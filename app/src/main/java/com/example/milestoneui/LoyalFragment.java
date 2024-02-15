package com.example.milestoneui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class LoyalFragment extends Fragment {



    androidx.constraintlayout.widget.ConstraintLayout cart;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loyal, container, false);



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
        RecyclerView recyclerView
                = view.findViewById(R.id.recyclerView2);

        cart = view.findViewById(R.id.cart123);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyBasketFragment fragmentB = new MyBasketFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        List<ItemClass> itemClasses = new ArrayList<>();


        itemClasses.add(new ItemClass(ItemClass.LayoutOne,
                "Dec 2023"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne,
                "Dec 2023"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne,
                "Dec 2023"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne,
                "Dec 2023"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne,
                "Dec 2023"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 11 Dec"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Invoice no:7345353", "wen 12 Dec"));


        AdapterClass adapterClass
                = new AdapterClass(itemClasses);

        AdapterClass adapter
                = new AdapterClass(itemClasses);


        recyclerView.setAdapter(adapter);

        return view;
    }

    private void navigateToNewFragment() {

        MyDealsFragment newFragment = new MyDealsFragment();

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container, newFragment);

        transaction.addToBackStack(null);

        transaction.commit();
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





}