package com.example.milestoneui;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView, recyclerView2;
    private MyAdapter adapter;
    private MyAdapter2 myAdapter2;
    private List<String> horizontalData;
    private List<String> horizontalData2;

    TextView moretxt, tetx1, history;
    ImageView moreimg, img1, cart;


    private RecyclerView recyclerView3;
    private AllAdapter adapter3;
    private List<ItemModel> dataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView3 = view.findViewById(R.id.recyclerView3);
        dataList = new ArrayList<>();


        dataList.add(new ItemModel(R.drawable.checken, "Poultry"));
        dataList.add(new ItemModel(R.drawable.tin, "Tin Products"));
        dataList.add(new ItemModel(R.drawable.sause, "Sause"));
        dataList.add(new ItemModel(R.drawable.spices, "Spices"));
        dataList.add(new ItemModel(R.drawable.bun, "Frozen"));
        dataList.add(new ItemModel(R.drawable.co2, "Drinks"));
        dataList.add(new ItemModel(R.drawable.containers, "Containers"));
        dataList.add(new ItemModel(R.drawable.cleningas, "Cleaning "));


        adapter3 = new AllAdapter(getContext(), dataList);
        recyclerView3.setLayoutManager(new GridLayoutManager(getContext(), 4));
        recyclerView3.setAdapter(adapter3);


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView2 = view.findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        moreimg = view.findViewById(R.id.morimg);
        moretxt = view.findViewById(R.id.textmore);
        tetx1 = view.findViewById(R.id.text1);
        img1 = view.findViewById(R.id.morimg3);
        history = view.findViewById(R.id.title);
        cart = view.findViewById(R.id.cart);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MyBasketActivity.class));
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToAllLyaol();
            }
        });

        tetx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToAllcategoriesFragment();
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToAllcategoriesFragment();
            }
        });

        horizontalData2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            horizontalData2.add("Item " + (i + 1));
        }

        myAdapter2 = new MyAdapter2(horizontalData2);
        recyclerView2.setAdapter(myAdapter2);

        horizontalData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            horizontalData.add("Offer ends 31/10");
        }
        adapter = new MyAdapter(getContext(), horizontalData, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                navigateToNewFragment();
            }
        });


        recyclerView.setAdapter(adapter);

        ImageView goToNewActivityButton = view.findViewById(R.id.back);
        goToNewActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToProfile();
            }
        });

        ImageView noti = view.findViewById(R.id.button3);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Notification.class));
            }
        });


        TextView productsearch = view.findViewById(R.id.productsearch);
        productsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTosearch();
            }
        });

        moretxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollToLastPosition2();
            }
        });

        moreimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollToLastPosition2();
            }
        });


        return view;
    }

    private void navigateToFragmentB() {
        SearchFragment fragmentB = new SearchFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentB);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private void navigateToAllcategoriesFragment() {
        AllCategoriesFragment fragmentB = new AllCategoriesFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentB);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void navigateToAllLyaol() {
        LoyalFragment fragmentB = new LoyalFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentB);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void scrollToLastPosition2() {
        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
    }

    private void navigateToNewFragment() {
        Intent intent = new Intent(getContext(), ProductDetailActivity.class);
        getContext().startActivity(intent);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            boolean navigateToHome = data.getBooleanExtra("navigate_to_home", false);
            if (navigateToHome) {
                navigateToHomeFragment();
            }
        }
    }




    private void navigateToHomeFragment() {
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void navigateToProfile() {
        ProfileFragment fragmentB = new ProfileFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentB);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void navigateTosearch() {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        startActivityForResult(intent, 1);
    }


}
