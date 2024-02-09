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

import java.util.List;

public class AllAdapter extends RecyclerView.Adapter<AllAdapter.AllViewHolder> {

    private List<ItemModel> dataList;
    private Context context;

    public AllAdapter(Context context, List<ItemModel> dataList) {
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
                navigateToHomeFragment(view.getContext());
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

    private void navigateToHomeFragment(Context context) {
        if (context instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) context;
            AllCategoriesFragment homeFragment = new AllCategoriesFragment();
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, homeFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }


}
