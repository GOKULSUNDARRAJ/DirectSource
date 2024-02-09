package com.example.milestoneui;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Browser2Adapter extends RecyclerView.Adapter<Browser2Adapter.Browser2ViewHolder> {

    private List<BrowseItem> itemList;
    private Context context;

    public Browser2Adapter(List<BrowseItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public Browser2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.browselist, parent, false);
        return new Browser2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Browser2ViewHolder holder, int position) {
        BrowseItem item = itemList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class Browser2ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public Browser2ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cart);
            textView = itemView.findViewById(R.id.itemText342);
        }

        public void bind(BrowseItem item) {
            imageView.setImageResource(item.getImageResource());
            textView.setText(item.getText());
        }
    }
}
