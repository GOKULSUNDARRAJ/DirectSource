package com.example.milestoneui;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProductDetailFragment extends Fragment {

    private ViewPager2 viewPager;
    private LinearLayout indicatorLayout;
    private int[] images = {R.drawable.icecream, R.drawable.co2, R.drawable.co1}; // Image resources
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int currentItem = viewPager.getCurrentItem();
            if (currentItem == images.length - 1) {
                viewPager.setCurrentItem(0);
            } else {
                viewPager.setCurrentItem(currentItem + 1);
            }
            handler.postDelayed(this, 5000); // 5000 milliseconds = 5 seconds
        }
    };

    ImageView add, minus;
    TextView count;

    CardView scanCard1, scanCard;

    LinearLayout linearLayout3;
    androidx.constraintlayout.widget.ConstraintLayout Cart;
    ImageView back;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_product_detail, container, false);


        linearLayout3=rootView.findViewById(R.id.linearLayout3);
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyBasketFragment myBasketFragment = new MyBasketFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, myBasketFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });




        add = rootView.findViewById(R.id.add);
        minus = rootView.findViewById(R.id.add1);
        count = rootView.findViewById(R.id.scantextview);

        scanCard1 = rootView.findViewById(R.id.scancard1);
        scanCard = rootView.findViewById(R.id.scancard);


        Cart =rootView.findViewById(R.id.cart123);
        Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyBasketFragment myBasketFragment = new MyBasketFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, myBasketFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        back = rootView.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragment fragmentB = new HomeFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
                bottomNavigationView.setSelectedItemId(R.id.navigation_hohomee);
            }
        });

        if (scanCard1 != null) {
            scanCard1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (scanCard1.getVisibility() == View.VISIBLE) {
                        scanCard1.setVisibility(View.GONE);
                        scanCard.setVisibility(View.VISIBLE);
                    } else {
                        scanCard1.setVisibility(View.VISIBLE);
                        scanCard.setVisibility(View.GONE);
                    }
                }
            });
        }
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }

                final int[] currentCount = {Integer.parseInt(count.getEditableText().toString())};
                if (currentCount[0] > 0) {
                    Animation slideDown = AnimationUtils.loadAnimation(v.getContext(), R.anim.slide_down);
                    count.startAnimation(slideDown);
                    slideDown.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {}

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            count.setVisibility(View.INVISIBLE);
                            currentCount[0]--;
                            count.setText(String.valueOf(currentCount[0]));
                            Animation slideUp = AnimationUtils.loadAnimation(v.getContext(), R.anim.slide_down);
                            count.startAnimation(slideUp);
                            count.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {}
                    });
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }

                int currentCount = Integer.parseInt(count.getEditableText().toString());
                currentCount++;
                Animation slideUp = AnimationUtils.loadAnimation(v.getContext(), R.anim.slide_up);
                count.startAnimation(slideUp);
                int finalCurrentCount = currentCount;
                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {}

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        count.setVisibility(View.INVISIBLE);
                        count.setText(String.valueOf(finalCurrentCount));
                        Animation slideIn = AnimationUtils.loadAnimation(v.getContext(), R.anim.slide_up);
                        count.startAnimation(slideIn);
                        count.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {}
                });
            }
        });

        viewPager = rootView.findViewById(R.id.viewPager);
        indicatorLayout = rootView.findViewById(R.id.indicatorLayout);

        // Create adapter for ViewPager2
        SliderAdapter adapter = new SliderAdapter(requireContext(), images);
        viewPager.setAdapter(adapter);

        // Add indicators
        addIndicators();

        // Update indicators when page changes
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });

        // Start auto-sliding when fragment is created
        startAutoSlide();

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stop auto-sliding when fragment is destroyed
        stopAutoSlide();
    }

    private void startAutoSlide() {
        handler.postDelayed(runnable, 5000); // Start after 5 seconds
    }

    private void stopAutoSlide() {
        handler.removeCallbacks(runnable);
    }

    private void addIndicators() {
        ImageView[] indicators = new ImageView[images.length];
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(requireContext());
            indicators[i].setImageResource(R.drawable.indicator_inactive);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(8, 0, 8, 0);
            indicatorLayout.addView(indicators[i], layoutParams);
        }
        setCurrentIndicator(0); // Set initial indicator as active
    }

    private void setCurrentIndicator(int position) {
        for (int i = 0; i < indicatorLayout.getChildCount(); i++) {
            ImageView imageView = (ImageView) indicatorLayout.getChildAt(i);
            if (i == position) {
                imageView.setImageResource(R.drawable.indicator_active);
            } else {
                imageView.setImageResource(R.drawable.indicator_inactive);
            }
        }
    }


}
