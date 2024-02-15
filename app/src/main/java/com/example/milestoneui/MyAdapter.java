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
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<MyModel> itemList;
    private Context context;
    private FragmentManager fragmentManager; // Add this field

    // Modify the constructor to accept FragmentManager
    public MyAdapter(Context context, List<MyModel> itemList, FragmentManager fragmentManager) {
        this.context = context;
        this.itemList = itemList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyModel item = itemList.get(position);

        // Bind your data to the views here
        holder.itemImage.setImageResource(item.getImageResource());
        holder.itemText1.setText(item.getText1());
        holder.itemText2.setText(item.getText2());
        holder.itemText3.setText(item.getText3());


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


        holder.carproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ProductDetailFragment(); // Replace ProductDetailFragment with your fragment
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null); // Add transaction to back stack so user can navigate back
                transaction.commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemText1, itemText2, itemText3;
        CardView cardView;

        public TextView itemText,Txt;
        public ImageView add1,minus;
        public CardView carproduct;

        EditText count;
        CardView scanCard1,scanCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemText1 = itemView.findViewById(R.id.itemText1);
            itemText2 = itemView.findViewById(R.id.itemText2);
            itemText3 = itemView.findViewById(R.id.itemText3);
            cardView = itemView.findViewById(R.id.carproduct);

            itemText = itemView.findViewById(R.id.itemText);
            itemImage =itemView.findViewById(R.id.itemImage);
            carproduct=itemView.findViewById(R.id.carproduct);
            scanCard1 =itemView.findViewById(R.id.scancard1);
            scanCard =itemView.findViewById(R.id.scancard);


            add1=itemView.findViewById(R.id.plus);
            minus=itemView.findViewById(R.id.minus);
            count =itemView.findViewById(R.id.scantextview);
        }
    }



}
