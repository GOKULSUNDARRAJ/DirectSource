package com.example.milestoneui;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.CustomViewHolder> {

    private List<MyDataModel> dataList;
    private Context context;

    public MyCustomAdapter(Context context, List<MyDataModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderdetaillist, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        MyDataModel data = dataList.get(position);

        holder.textView2.setText(data.getOrderID());
        holder.textView3.setText("Qty: " + data.getQuantity());
        holder.textView45.setText(data.getPrice());


        Glide.with(context)
                .load(data.getImageResourceId())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView textView2, textView3, textView45;
        ImageView imageView;
        CardView cardView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView45 = itemView.findViewById(R.id.textView45);
            imageView = itemView.findViewById(R.id.title2); // ImageView for the image
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
