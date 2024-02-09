package com.example.milestoneui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FilterFragment extends Fragment {

    private TextView textView;
    private AllAdapter2 adapter1;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView3;
    private LinearLayout linearLayout, linearLayout2, linearLayout3, Filter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_filter, container, false);

        linearLayout = view.findViewById(R.id.linearLayout);
        linearLayout2 = view.findViewById(R.id.linearLayout4);
        linearLayout3 = view.findViewById(R.id.linearLayout46);
        Filter = view.findViewById(R.id.linearLayout14);



        ImageView back1=view.findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseFragment fragmentB = new BrowseFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView3 = view.findViewById(R.id.recyclerView3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));

        List<FilterItem> filterItemList = new ArrayList<>();
        filterItemList.add(new FilterItem("Item 1"));
        filterItemList.add(new FilterItem("Item 1"));
        filterItemList.add(new FilterItem("Brand2"));
        filterItemList.add(new FilterItem("Brand3"));
        filterItemList.add(new FilterItem("Brand4"));
        filterItemList.add(new FilterItem("Brand5"));
        filterItemList.add(new FilterItem("Brand6"));
        filterItemList.add(new FilterItem("Brand7"));
        filterItemList.add(new FilterItem("Brand8"));
        filterItemList.add(new FilterItem("Brand9"));
        filterItemList.add(new FilterItem("Brand10"));
        filterItemList.add(new FilterItem("Brand11"));
        filterItemList.add(new FilterItem("Brand12"));

        FilterAdapter adapter = new FilterAdapter(getContext(), filterItemList);
        recyclerView.setAdapter(adapter);

        List<FilterItem3> filterItemList3 = new ArrayList<>();
        filterItemList3.add(new FilterItem3("Item 1"));
        filterItemList3.add(new FilterItem3("Item 1"));
        filterItemList3.add(new FilterItem3("Offers"));
        filterItemList3.add(new FilterItem3("Offers"));
        filterItemList3.add(new FilterItem3("Offers"));
        filterItemList3.add(new FilterItem3("Offers"));
        filterItemList3.add(new FilterItem3("Offers"));
        filterItemList3.add(new FilterItem3("Offers"));
        filterItemList3.add(new FilterItem3("Offers"));
        filterItemList3.add(new FilterItem3("Offers"));

        FilterAdapter3 adapter3 = new FilterAdapter3(getContext(), filterItemList3);
        recyclerView3.setAdapter(adapter3);

        RecyclerView recyclerView2 = view.findViewById(R.id.recyclerView2);
        textView = view.findViewById(R.id.textView);

        List<ItemModel> dataList = createSampleData();
        adapter1 = new AllAdapter2(getContext(), dataList);
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView2.setAdapter(adapter1);

        Filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySelectedItems();
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView2.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                recyclerView3.setVisibility(View.GONE);
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView2.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                recyclerView3.setVisibility(View.GONE);
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView2.setVisibility(View.GONE);
                recyclerView3.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            }
        });


        ImageView backImageView = view.findViewById(R.id.back);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle back button click
                // You might want to handle this based on your navigation requirements
            }
        });

        return view;
    }

    private List<ItemModel> createSampleData() {
        List<ItemModel> sampleData = new ArrayList<>();
        sampleData.add(new ItemModel(R.drawable.checken, "Poultry"));
        sampleData.add(new ItemModel(R.drawable.tin, "Tin Products"));
        sampleData.add(new ItemModel(R.drawable.sause, "Sauce"));
        sampleData.add(new ItemModel(R.drawable.spices, "Spices"));
        sampleData.add(new ItemModel(R.drawable.bun, "Frozen"));
        sampleData.add(new ItemModel(R.drawable.co2, "Drinks"));
        sampleData.add(new ItemModel(R.drawable.containers, "Containers"));
        sampleData.add(new ItemModel(R.drawable.cleningas, "Cleaning"));
        sampleData.add(new ItemModel(R.drawable.daier, "Dairy"));
        sampleData.add(new ItemModel(R.drawable.pizza, "Pizza"));
        sampleData.add(new ItemModel(R.drawable.nets, "Nuts"));
        sampleData.add(new ItemModel(R.drawable.len, "Lentils"));
        sampleData.add(new ItemModel(R.drawable.chuttny, "Chutney"));
        sampleData.add(new ItemModel(R.drawable.boxes, "Boxes"));
        sampleData.add(new ItemModel(R.drawable.ser, "Serviette"));
        sampleData.add(new ItemModel(R.drawable.oil, "Oils Fats"));
        sampleData.add(new ItemModel(R.drawable.cleningas, "Cleanings"));
        sampleData.add(new ItemModel(R.drawable.ricebag, "Rice"));
        sampleData.add(new ItemModel(R.drawable.breadind, "Breasing"));
        sampleData.add(new ItemModel(R.drawable.carrybags, "Bag"));
        return sampleData;
    }

    private void displaySelectedItems() {
        List<ItemModel> selectedItems = adapter1.getSelectedItems();
        List<String> selectedFilterItems = ((FilterAdapter) recyclerView.getAdapter()).getSelectedItems();
        List<String> selectedFilterItems3 = ((FilterAdapter3) recyclerView3.getAdapter()).getSelectedItems();

        StringBuilder selectedNames = new StringBuilder();

        for (ItemModel item : selectedItems) {
            selectedNames.append(item.getItemName()).append("\n");
        }

        for (String item : selectedFilterItems) {
            selectedNames.append(item).append("\n");
        }

        for (String item : selectedFilterItems3) {
            selectedNames.append(item).append("\n");
        }

        if (selectedNames.length() == 0) {
            // Handle case when no items are selected
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("selectedItems", selectedNames.toString());

            BrowseFragment newFragment = new BrowseFragment();
            newFragment.setArguments(bundle);


            int containerId = R.id.fragment_container;

            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(containerId, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

}




