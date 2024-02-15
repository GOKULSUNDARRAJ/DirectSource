package com.example.milestoneui;

import static android.app.appsearch.AppSearchResult.RESULT_OK;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MyBasketFragment extends Fragment {

    private static final String TAG = "MyBasketActivity";

    Button btn;
    LinearLayout lin1, lin2, lin3, lin4, lin5, checkoutnowt;
    LinearLayout checkout;

    LinearLayout continuetoShoping;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_my_basket, container, false);




        continuetoShoping=view.findViewById(R.id.lin4);
        continuetoShoping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// Create a new instance of the BrowseFragment
                BrowseFragment browseFragment = new BrowseFragment();

                // Get the FragmentManager and start a transaction
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();

                // Replace the current fragment in the fragment_container with the BrowseFragment
                // Add this transaction to the back stack so the user can navigate back
                transaction.replace(R.id.fragment_container, browseFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();

                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
                bottomNavigationView.setSelectedItemId(R.id.browse); // Set the item id of the BrowseFragment
            }
        });



        checkoutnowt =view.findViewById(R.id.checkoutnowt);
        checkoutnowt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CheckOutActivity.class);
                startActivity(intent);
            }
        });

        btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });

        checkout = view.findViewById(R.id.checkoutnow);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CheckOutActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        ImageView goToHomeButton;
        goToHomeButton = view.findViewById(R.id.back);
        goToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HomeFragment fragmentB = new HomeFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
                bottomNavigationView.setSelectedItemId(R.id.navigation_hohomee);
            }
        });

        ArrayList<MyBasketItem> myBasketItems = new ArrayList<>();
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.checken));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.co1));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.checken));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.sause));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.carrybags));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.checken));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.co1));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.checken));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.sause));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.carrybags));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.spices));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.checken));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.sause));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.carrybags));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.checken));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.co1));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.checken));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.sause));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.carrybags));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.checken));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.checken));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.sause));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.carrybags));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.spices));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.spices));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.sause));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.carrybags));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.checken));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.checken));
        myBasketItems.add(new MyBasketItem("Cucumbers", "BAK403", "(Class L)-1x(14-16)", R.drawable.sause));

        RecyclerView recyclerView =view.findViewById(R.id.recyclerView);

        if (recyclerView == null) {
            Log.e(TAG, "RecyclerView is null");
            return view;
        }

        TextView title23TextView = view.findViewById(R.id.title23);
        if (title23TextView != null) {
            title23TextView.setText("Total items (" + myBasketItems.size() + ")");
        } else {
            Log.e(TAG, "title23 TextView is null");
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        lin1 = view.findViewById(R.id.lin1);
        lin2 = view.findViewById(R.id.lin2);
        lin3 = view.findViewById(R.id.lin6);
        lin4 = view.findViewById(R.id.lin4);
        lin5 = view.findViewById(R.id.checkoutnow);

        if (myBasketItems.isEmpty()) {
            lin3.setVisibility(View.VISIBLE);
            lin2.setVisibility(View.INVISIBLE);
            lin1.setVisibility(View.INVISIBLE);
            lin4.setVisibility(View.INVISIBLE);
            lin5.setVisibility(View.INVISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            lin3.setVisibility(View.INVISIBLE);
            lin1.setVisibility(View.VISIBLE);
            lin2.setVisibility(View.VISIBLE);
            lin4.setVisibility(View.VISIBLE);
            lin5.setVisibility(View.VISIBLE);
        }

        MyBasketItemsAdapter adapter = new MyBasketItemsAdapter(getContext(), myBasketItems);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                if (direction == ItemTouchHelper.LEFT) {
                    adapter.removeItem(position);
                } else if (direction == ItemTouchHelper.RIGHT) {
                    showCustomDialogSwap();
                }

                if (adapter.getItemCount() == 1) {
                    lin3.setVisibility(View.VISIBLE);
                    lin2.setVisibility(View.INVISIBLE);
                    lin1.setVisibility(View.INVISIBLE);
                    lin4.setVisibility(View.INVISIBLE);
                    lin5.setVisibility(View.INVISIBLE);
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    lin3.setVisibility(View.INVISIBLE);
                    lin1.setVisibility(View.VISIBLE);
                    lin2.setVisibility(View.VISIBLE);
                    lin4.setVisibility(View.VISIBLE);
                    lin5.setVisibility(View.VISIBLE);
                }

                TextView title23TextView = view.findViewById(R.id.title23);
                if (title23TextView != null) {
                    title23TextView.setText("Total items (" + (adapter.getItemCount() - 1) + ")");
                } else {
                    Log.e(TAG, "title23 TextView is null");
                }
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                View itemView = viewHolder.itemView;
                ColorDrawable background;
                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                paint.setTextSize(48);
                paint.setTextAlign(Paint.Align.CENTER);
                Rect bounds = new Rect();
                paint.getTextBounds("Delete", 0, "Delete".length(), bounds);
                int x = itemView.getRight() + (int) dX / 2;
                int y = itemView.getTop() + itemView.getHeight() / 2 + bounds.height() / 2;

                if (dX > 0) {

                    background = new ColorDrawable(Color.BLUE);
                    background.setBounds(itemView.getLeft(), itemView.getTop(), itemView.getLeft() + (int) dX / 2, itemView.getBottom());
                    background.draw(c);
                    c.drawText("Related Products", itemView.getLeft() + (int) dX / 4, y, paint);
                } else if (dX < 0) {

                    background = new ColorDrawable(Color.RED);
                    background.setBounds(itemView.getRight() + (int) dX, itemView.getTop(), itemView.getRight(), itemView.getBottom());
                    background.draw(c);
                    c.drawText("Delete", x, y, paint);
                } else {
                    background = new ColorDrawable(Color.TRANSPARENT);
                    background.setBounds(0, 0, 0, 0);
                    background.draw(c);
                }
            }



        };


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        return view;
    }



    private void showCustomDialog() {
        CustomDialogClassbookyourslot cdd = new CustomDialogClassbookyourslot(getContext());
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
    }
    private void showCustomDialogSwap() {
        List<SwapItem> swapItemList = new ArrayList<>();
        swapdialog cdd = new swapdialog(getContext(), swapItemList);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        cdd.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });

        cdd.show();
    }


}