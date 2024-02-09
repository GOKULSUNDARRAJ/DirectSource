package com.example.milestoneui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AllAdapter2 extends RecyclerView.Adapter<AllAdapter2.AllViewHolder> {

    private List<ItemModel> dataList;
    private Context context;
    private List<ItemModel> selectedItems;

    public AllAdapter2(Context context, List<ItemModel> dataList) {
        this.context = context;
        this.dataList = dataList;
        this.selectedItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public AllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category2, parent, false);
        return new AllViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllViewHolder holder, int position) {
        ItemModel item = dataList.get(position);
        holder.bind(item);
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public List<ItemModel> getSelectedItems() {
        return selectedItems;
    }

    public class AllViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemText;

        LinearLayout round;

        public AllViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemText = itemView.findViewById(R.id.itemText);
            round=itemView.findViewById(R.id.round);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        ItemModel item = dataList.get(position);
                        if (selectedItems.contains(item)) {
                            selectedItems.remove(item);
                        } else {
                            selectedItems.add(item);
                        }
                        notifyItemChanged(position);
                    }
                }
            });
        }

        public void bind(ItemModel item) {
            itemText.setText(item.getItemName());
            itemImage.setImageResource(item.getImageResource());


            if (selectedItems.contains(item)) {
             round.setBackgroundResource(R.drawable.roundred);
            } else {
                round.setBackgroundColor(Color.WHITE);
            }
        }


        public void clearSelections() {
            selectedItems.clear();
            notifyDataSetChanged();
        }

    }
}




