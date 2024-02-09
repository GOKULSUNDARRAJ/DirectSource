package com.example.milestoneui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileFragment extends Fragment {

    LinearLayout savedAddress, edit, offers, fav,orderlayout,noti;
    ConstraintLayout reset;
    ImageView back;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);

        back = view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToHome();
            }
        });

        noti=view.findViewById(R.id.noti);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),Notification.class));
            }
        });

        orderlayout=view.findViewById(R.id.orderlayout);
        orderlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),MyOrderActivity.class));
            }
        });

        offers = view.findViewById(R.id.gotooffer);
        offers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBrowseFragmentOffer();
            }
        });



        reset = view.findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), ResetPassActivity.class);
                startActivity(intent);
            }
        });

        fav = view.findViewById(R.id.fav123);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBrowseFragment();
            }
        });

        savedAddress = view.findViewById(R.id.savedaddress);
        savedAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(requireContext(), SavedAddressActivity.class));
            }
        });

        edit = view.findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(requireContext(), EditProfileActivity.class));
            }
        });

        return view;
    }

    private void navigateToHome() {

        HomeFragment fragmentB = new HomeFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentB);
        transaction.addToBackStack(null);
        transaction.commit();
        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_hohomee);
    }

    private void goToBrowseFragment() {
        // Create a new instance of the BrowseFragment
        FavoriteFragment browseFragment = new FavoriteFragment();

        // Get the FragmentManager and start a transaction
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();

        // Replace the current fragment in the fragment_container with the BrowseFragment
        // Add this transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, browseFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.fav); // Set the item id of the BrowseFragment
    }
    private void goToBrowseFragmentOffer() {
        // Create a new instance of the BrowseFragment
        MyDealsFragment browseFragment = new MyDealsFragment();

        // Get the FragmentManager and start a transaction
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();

        // Replace the current fragment in the fragment_container with the BrowseFragment
        // Add this transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, browseFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();

        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.deals); // Set the item id of the BrowseFragment
    }


}
