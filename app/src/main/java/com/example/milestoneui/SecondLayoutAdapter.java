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
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SecondLayoutAdapter extends RecyclerView.Adapter<SecondLayoutAdapter.ViewHolder> {

    private List<CommonModel> dataList;
    private Context context;

    public SecondLayoutAdapter(Context context, List<CommonModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fav_item_layout_2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CommonModel model = dataList.get(position);
        holder.itemText.setText(model.getItemText());
        holder.itemImage.setImageResource(model.getImageResource());


        holder.laypro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProductDetailActivity.class);
                view.getContext().startActivity(intent);
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
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemText;
        ImageView itemImage;

        LinearLayout laypro;

        CardView scanCard1, scanCard;


        public ImageView add1, minus;


        EditText count;

        public ViewHolder(View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.itemText);
            itemImage = itemView.findViewById(R.id.cart);
            laypro = itemView.findViewById(R.id.laypro);

            scanCard1 = itemView.findViewById(R.id.scancard1);
            scanCard = itemView.findViewById(R.id.scancard);
            add1 = itemView.findViewById(R.id.plus);
            minus = itemView.findViewById(R.id.minus);
            count = itemView.findViewById(R.id.scantextview);


        }
    }
}
