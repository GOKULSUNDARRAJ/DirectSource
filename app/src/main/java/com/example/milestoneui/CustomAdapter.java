package com.example.milestoneui;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.milestoneui.R; // Change this to your correct package name
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<CudModel> dataList;
    private Context context;

    public CustomAdapter(Context context, List<CudModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myorderitems, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CudModel data = dataList.get(position);


        holder.textView2.setText(data.getOrderID());
        holder.textView3.setText(data.getOrderDate());
        holder.textView4.setText(data.getStatus());
        holder.textView45.setText(data.getPrice());
        Glide.with(context)
                .load(data.getImageResourceId())
                .into(holder.title2);

        holder.title2.setImageResource(data.getImageResourceId());

        holder.Carditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent=new Intent(view.getContext(),OrderDeatailsActivity.class);
               view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView2, textView3, textView4, textView45;
        ImageView title2, img, img2;
        Button button33;
        CardView cardView2;

        LinearLayout Carditem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
            textView45 = itemView.findViewById(R.id.textView45);
            title2 = itemView.findViewById(R.id.title2);
            img = itemView.findViewById(R.id.img);
            img2 = itemView.findViewById(R.id.img2);
            button33 = itemView.findViewById(R.id.button33);
            cardView2 = itemView.findViewById(R.id.cardView2);
            Carditem=itemView.findViewById(R.id.carditem);
        }
    }
}
