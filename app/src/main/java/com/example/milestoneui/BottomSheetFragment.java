package com.example.milestoneui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_layout, container, false);


        Button signUpButton = view.findViewById(R.id.conbtn);


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openNewBottomSheet();
            }
        });

        return view;
    }

    private void openNewBottomSheet() {

        ForgetLinkBottomSheetFragment newBottomSheetFragment = new ForgetLinkBottomSheetFragment();


        newBottomSheetFragment.show(getChildFragmentManager(), newBottomSheetFragment.getTag());
    }
}

