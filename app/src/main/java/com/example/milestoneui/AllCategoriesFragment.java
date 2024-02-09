package com.example.milestoneui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class AllCategoriesFragment extends Fragment {


    private RecyclerView recyclerView3;
    private AllAdapter3 adapter3;
    private List<ItemModel> dataList;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_categories, container, false);




        recyclerView3 = view.findViewById(R.id.recyclerView3);
        dataList = new ArrayList<>();


        dataList.add(new ItemModel(R.drawable.checken, "Poultry"));
        dataList.add(new ItemModel(R.drawable.tin, "Tin Products"));
        dataList.add(new ItemModel(R.drawable.sause, "Sause"));
        dataList.add(new ItemModel(R.drawable.spices, "Spices"));
        dataList.add(new ItemModel(R.drawable.bun, "Frozen Food"));
        dataList.add(new ItemModel(R.drawable.co2, "Drinks"));
        dataList.add(new ItemModel(R.drawable.containers, "Containers"));
        dataList.add(new ItemModel(R.drawable.cleningas, "Cleaning"));
        dataList.add(new ItemModel(R.drawable.daier, "Dairy"));
        dataList.add(new ItemModel(R.drawable.pizza, "Pizza"));
        dataList.add(new ItemModel(R.drawable.nets, "Nuts"));
        dataList.add(new ItemModel(R.drawable.len, "Lentils"));
        dataList.add(new ItemModel(R.drawable.chuttny, "Chutney"));
        dataList.add(new ItemModel(R.drawable.boxes, "Boxes"));
        dataList.add(new ItemModel(R.drawable.ser, "Serviette"));
        dataList.add(new ItemModel(R.drawable.oil, "Oils Fats"));
        dataList.add(new ItemModel(R.drawable.cleningas, "Cleanings"));
        dataList.add(new ItemModel(R.drawable.ricebag, "Rice"));
        dataList.add(new ItemModel(R.drawable.breadind, "Breasing"));
        dataList.add(new ItemModel(R.drawable.carrybags, "Bag"));





        adapter3 = new AllAdapter3(getContext(), dataList);
        recyclerView3.setLayoutManager(new GridLayoutManager(getContext(), 4));
        recyclerView3.setAdapter(adapter3);
        return view;
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