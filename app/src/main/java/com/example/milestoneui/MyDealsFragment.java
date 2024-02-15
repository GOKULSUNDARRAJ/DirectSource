package com.example.milestoneui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MyDealsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProductAdapter gridProductAdapter;
    private ProductListAdapter listProductAdapter;
    private List<Product> productList;

    private androidx.constraintlayout.widget.ConstraintLayout cart;


    private FavoriteFragment.OnBackPressedListener onBackPressedListener;

    public interface OnBackPressedListener {
        void onBackPress();
    }



    Button sortbtn, listbtn, filter;
    boolean isListView = false;

    ImageView Image;
    TextView searchEditText;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_deals, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        productList = new ArrayList<>();

        listbtn = view.findViewById(R.id.button387);
        sortbtn = view.findViewById(R.id.button33);
        filter = view.findViewById(R.id.button3);



        Image=view.findViewById(R.id.Image);

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



        searchEditText = view.findViewById(R.id.productsearch);
        searchEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),SearchActivity.class));
            }
        });


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





        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilterFragment fragmentB = new FilterFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });



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




        listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isListView = !isListView;
                if (isListView) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(listProductAdapter);
                } else {
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    recyclerView.setAdapter(gridProductAdapter);
                }
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


        populateDummyData();


        gridProductAdapter = new ProductAdapter(productList,getParentFragmentManager());
        listProductAdapter = new ProductListAdapter(productList,getParentFragmentManager());


        recyclerView.setAdapter(gridProductAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return view;
    }

    private void populateDummyData() {
        productList.add(new Product("1", "Coca-Cola", R.drawable.cleningas));
        productList.add(new Product("1", "Coca-Cola", R.drawable.checken));
        productList.add(new Product("1", "Coca-Cola", R.drawable.sause));
        productList.add(new Product("1", "Coca-Cola", R.drawable.checken));
        productList.add(new Product("1", "Coca-Cola", R.drawable.sause));
        productList.add(new Product("1", "Coca-Cola", R.drawable.sause));
        productList.add(new Product("1", "Coca-Cola", R.drawable.carrybags));
        productList.add(new Product("1", "Coca-Cola", R.drawable.checken));
        productList.add(new Product("1", "Coca-Cola", R.drawable.carrybags));
        productList.add(new Product("1", "Coca-Cola", R.drawable.checken));
        productList.add(new Product("1", "Coca-Cola", R.drawable.sause));
        productList.add(new Product("1", "Coca-Cola", R.drawable.sause));
        productList.add(new Product("1", "Coca-Cola", R.drawable.carrybags));
        productList.add(new Product("1", "Coca-Cola", R.drawable.checken));
        productList.add(new Product("1", "Coca-Cola", R.drawable.carrybags));



    }



    private void navigateToNewFragment() {

        if (getActivity() != null && getActivity() instanceof ProfileActivity) {

            getActivity().onBackPressed();
        } else {
            if (onBackPressedListener != null) {
                onBackPressedListener.onBackPress();
            }
        }
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

    private void navigateToProfile() {
        ProfileFragment fragmentB = new ProfileFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentB);
        transaction.addToBackStack(null);
        transaction.commit();
    }




}
