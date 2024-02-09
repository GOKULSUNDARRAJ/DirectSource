package com.example.milestoneui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {


    private OnBackPressedListener onBackPressedListener;

    public interface OnBackPressedListener {
        void onBackPress();
    }





    private RecyclerView recyclerView;
    private FirstLayoutAdapter adapter1;
    private SecondLayoutAdapter adapter2;
    private List<CommonModel> itemList;

    Button listbtn;

    boolean isListView = false;
    androidx.constraintlayout.widget.ConstraintLayout cart;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        listbtn = view.findViewById(R.id.button387);


        ImageView back1=view.findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment fragmentB = new ProfileFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });




        cart=view.findViewById(R.id.cart123);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),MyBasketActivity.class));
            }
        });
        itemList = new ArrayList<>();
        populateDummyData();

        adapter1 = new FirstLayoutAdapter(requireContext(), itemList);
        adapter2 = new SecondLayoutAdapter(requireContext(), itemList);

        setRecyclerViewLayoutManager();

        listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isListView = !isListView;
                setRecyclerViewLayoutManager();
            }
        });

        return view;
    }

    private void populateDummyData() {
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.checken));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.productimage));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.carrybags));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.sause));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.spices));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.co2));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.cleningas));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.carrybags));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.sause));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.spices));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.co2));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.cleningas));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.carrybags));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.sause));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.spices));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.co2));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.cleningas));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.carrybags));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.sause));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.spices));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.co2));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.cleningas));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.carrybags));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.sause));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.spices));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.co2));
        itemList.add(new CommonModel("Offer ends 31/10", R.drawable.cleningas));

    }

    private void setRecyclerViewLayoutManager() {
        if (isListView) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter2);
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            recyclerView.setAdapter(adapter1);
        }


    }




    @Override
    public void onStart() {
        super.onStart();
        showBottomNavigation();
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
    private void navigateToNewFragment() {
        // Check if the parent activity is an instance of ProfileActivity
        if (getActivity() != null && getActivity() instanceof ProfileActivity) {
            // If opened from ProfileActivity, navigate back to ProfileActivity
            getActivity().onBackPressed();
        } else {
            if (onBackPressedListener != null) {
                onBackPressedListener.onBackPress();
            }
        }
    }

}
