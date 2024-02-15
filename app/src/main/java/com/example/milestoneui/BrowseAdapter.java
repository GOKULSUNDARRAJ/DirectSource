package com.example.milestoneui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.milestoneui.BrowseItem;
import com.example.milestoneui.R;

import java.util.List;

public class BrowseAdapter extends RecyclerView.Adapter<BrowseAdapter.BrowseViewHolder> {

    private Context context;
    private List<BrowseItem> itemList;
    private FragmentManager fragmentManager;


    public void setItems(List<BrowseItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    public BrowseAdapter(Context context, List<BrowseItem> itemList, FragmentManager fragmentManager) {
        this.context = context;
        this.itemList = itemList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public BrowseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.browselist, parent, false);
        return new BrowseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrowseViewHolder holder, int position) {
        BrowseItem item = itemList.get(position);
        holder.imageView.setImageResource(item.getImageResource());
        holder.textView.setText(item.getTitle());


        holder.laypro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ProductDetailFragment(); // Replace ProductDetailFragment with your fragment
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null); // Add transaction to back stack so user can navigate back
                transaction.commit();
            }
        });


        holder.scanCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (holder.scanCard1.getVisibility() == View.VISIBLE) {
                    holder.scanCard1.setVisibility(View.GONE);
                    holder.scanCard.setVisibility(View.VISIBLE);
                } else {
                    holder.scanCard1.setVisibility(View.VISIBLE);
                    holder.scanCard.setVisibility(View.GONE);
                }
            }
        });




        holder.add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }

                final int[] currentCount = {Integer.parseInt(holder.count.getEditableText().toString())};
                if (currentCount[0] > 0) {

                    Animation slideDown = AnimationUtils.loadAnimation(v.getContext(), R.anim.slide_down);
                    holder.count.startAnimation(slideDown);


                    slideDown.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            holder.count.setVisibility(View.INVISIBLE);


                            currentCount[0]--;
                            holder.count.setText(String.valueOf(currentCount[0]));


                            Animation slideUp = AnimationUtils.loadAnimation(v.getContext(), R.anim.slide_down);
                            holder.count.startAnimation(slideUp);

                            holder.count.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                }


            }

        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }

                int currentCount = Integer.parseInt(holder.count.getEditableText().toString());
                currentCount++;


                Animation slideUp = AnimationUtils.loadAnimation(v.getContext(), R.anim.slide_up);
                holder.count.startAnimation(slideUp);


                int finalCurrentCount = currentCount;
                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        holder.count.setVisibility(View.INVISIBLE);


                        holder.count.setText(String.valueOf(finalCurrentCount));


                        Animation slideIn = AnimationUtils.loadAnimation(v.getContext(), R.anim.slide_up);
                        holder.count.startAnimation(slideIn);


                        holder.count.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class BrowseViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        LinearLayout laypro;
        CardView scanCard1,scanCard;


        public ImageView add1,minus;


        EditText count;
        public BrowseViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cart);
            textView = itemView.findViewById(R.id.itemText342);
            laypro=itemView.findViewById(R.id.laypro);


            scanCard1 =itemView.findViewById(R.id.scancard1);
            scanCard =itemView.findViewById(R.id.scancard);
            add1=itemView.findViewById(R.id.plus);
            minus=itemView.findViewById(R.id.minus);
            count =itemView.findViewById(R.id.scantextview);
        }
    }


}
