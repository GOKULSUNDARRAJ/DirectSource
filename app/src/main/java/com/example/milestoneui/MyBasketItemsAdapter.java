package com.example.milestoneui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyBasketItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_PRODUCT = 0;
    private static final int VIEW_TYPE_BUTTON = 1;

    private Context context;
    private ArrayList<MyBasketItem> myBasketItems;

    public MyBasketItemsAdapter(Context context, ArrayList<MyBasketItem> myBasketItems) {
        this.context = context;
        this.myBasketItems = myBasketItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_BUTTON) {
            View buttonView = LayoutInflater.from(context).inflate(R.layout.button_layout, parent, false);
            return new ButtonViewHolder(buttonView);
        } else {
            View productView = LayoutInflater.from(context).inflate(R.layout.mybasketitems, parent, false);
            return new ProductViewHolder(productView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VIEW_TYPE_PRODUCT) {
            ProductViewHolder productViewHolder = (ProductViewHolder) holder;
            MyBasketItem currentItem = myBasketItems.get(position);
            productViewHolder.productName.setText(currentItem.getProductName());
            productViewHolder.productCode.setText(currentItem.getProductCode());
            productViewHolder.productDetails.setText(currentItem.getProductDetails());


            Glide.with(context)
                    .load(currentItem.getImageResourceId())
                    .into(productViewHolder.productImage);


            productViewHolder.add1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }

                    final int[] currentCount = {Integer.parseInt(productViewHolder.count.getEditableText().toString())};
                    if (currentCount[0] > 0) {

                        Animation slideDown = AnimationUtils.loadAnimation(v.getContext(), R.anim.slide_down);
                        productViewHolder.count.startAnimation(slideDown);


                        slideDown.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                productViewHolder.count.setVisibility(View.INVISIBLE);


                                currentCount[0]--;
                                productViewHolder.count.setText(String.valueOf(currentCount[0]));


                                Animation slideUp = AnimationUtils.loadAnimation(v.getContext(), R.anim.slide_down);
                                productViewHolder.count.startAnimation(slideUp);

                                productViewHolder.count.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {
                            }
                        });
                    }


                }

            });

            productViewHolder.minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }

                    int currentCount = Integer.parseInt(productViewHolder.count.getEditableText().toString());
                    currentCount++;


                    Animation slideUp = AnimationUtils.loadAnimation(v.getContext(), R.anim.slide_up);
                    productViewHolder.count.startAnimation(slideUp);


                    int finalCurrentCount = currentCount;
                    slideUp.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            productViewHolder.count.setVisibility(View.INVISIBLE);


                            productViewHolder.count.setText(String.valueOf(finalCurrentCount));


                            Animation slideIn = AnimationUtils.loadAnimation(v.getContext(), R.anim.slide_up);
                            productViewHolder.count.startAnimation(slideIn);


                            productViewHolder.count.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                }
            });


            productViewHolder.scanCard1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (productViewHolder.scanCard1.getVisibility() == View.VISIBLE) {
                        productViewHolder.scanCard1.setVisibility(View.GONE);
                        productViewHolder.scanCard.setVisibility(View.VISIBLE);
                    } else {
                        productViewHolder.scanCard1.setVisibility(View.VISIBLE);
                        productViewHolder.scanCard.setVisibility(View.GONE);
                    }
                }
            });


        } else {


        }
    }

    @Override
    public int getItemCount() {
        return myBasketItems.size() + 1;
    }

    public void removeItem(int position) {
        myBasketItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemViewType(int position) {
        return (position == myBasketItems.size()) ? VIEW_TYPE_BUTTON : VIEW_TYPE_PRODUCT;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView productImage;
        public TextView productName;
        public TextView productCode;
        public TextView productDetails;

        CardView scanCard1, scanCard;

        public ImageView add1,minus;


        EditText count;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.cart);
            productName = itemView.findViewById(R.id.title3);
            productCode = itemView.findViewById(R.id.title2);
            productDetails = itemView.findViewById(R.id.title1);

            scanCard1 = itemView.findViewById(R.id.scancard1);
            scanCard = itemView.findViewById(R.id.scancard);

            add1=itemView.findViewById(R.id.plus);
            minus=itemView.findViewById(R.id.minus);
            count =itemView.findViewById(R.id.scantextview);

        }
    }

    public static class ButtonViewHolder extends RecyclerView.ViewHolder {


        public ButtonViewHolder(@NonNull View itemView) {
            super(itemView);



        }
    }
}
