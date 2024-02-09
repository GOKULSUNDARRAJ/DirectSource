package com.example.milestoneui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FilterAdapter2 extends RecyclerView.Adapter<FilterAdapter2.FilterViewHolder> {
    private List<FilterItem2> filterList;
    private Context context;

    public FilterAdapter2(Context context, List<FilterItem2> filterList) {
        this.context = context;
        this.filterList = filterList;
    }

    @NonNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_filter, parent, false);
        return new FilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterViewHolder holder, int position) {
        FilterItem2 item = filterList.get(position);
        holder.textView.setText(item.getName());
        holder.checkBox.setChecked(item.isSelected());

        // Set a click listener for the CheckBox
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setSelected(holder.checkBox.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public static class FilterViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView textView;

        public FilterViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);
            textView = itemView.findViewById(R.id.froget);
        }
    }

    public List<String> getSelectedItems() {
        List<String> selectedItems = new ArrayList<>();
        for (FilterItem2 item : filterList) {
            if (item.isSelected()) {
                selectedItems.add(item.getName());
            }
        }
        return selectedItems;
    }
}
