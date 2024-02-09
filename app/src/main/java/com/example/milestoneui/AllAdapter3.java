package com.example.milestoneui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class AllAdapter3 extends RecyclerView.Adapter<AllAdapter3.AllViewHolder> {

    private List<ItemModel> dataList;
    private Context context;

    public AllAdapter3(Context context, List<ItemModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public AllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category, parent, false);
        return new AllViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllViewHolder holder, int position) {
        ItemModel item = dataList.get(position);
        holder.itemText.setText(item.getItemName());
        holder.itemImage.setImageResource(item.getImageResource());

        holder.pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToBrowseFragment(view.getContext());
            }

        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class AllViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemText;
        androidx.constraintlayout.widget.ConstraintLayout pro;


        public AllViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemText = itemView.findViewById(R.id.itemText);
            pro = itemView.findViewById(R.id.pro1);

        }
    }

    private void navigateToBrowseFragment(Context context) {
        if (context instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) context;
            BrowseFragment browseFragment = new BrowseFragment();
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, browseFragment)
                    .addToBackStack(null)
                    .commit();

            // Assuming you have a bottom navigation view with an id of bottom_navigation
            BottomNavigationView bottomNavigationView = activity.findViewById(R.id.bottom_navigation);
            bottomNavigationView.setSelectedItemId(R.id.browse); // Set the item id of the BrowseFragment
        }
    }



}
