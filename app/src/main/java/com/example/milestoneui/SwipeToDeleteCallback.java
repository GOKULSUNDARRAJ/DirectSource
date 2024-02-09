package com.example.milestoneui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {

    private final Drawable icon;
    private final ColorDrawable background;

    public SwipeToDeleteCallback(Drawable icon) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.icon = icon;
        this.background = new ColorDrawable(Color.RED); // Change background color as needed
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        // Handle swipe action here, e.g., remove item from your data
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                            @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY,
                            int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        // Get item view bounds
        View itemView = viewHolder.itemView;
        int itemHeight = itemView.getBottom() - itemView.getTop();
        int iconWidth = icon.getIntrinsicWidth();
        int iconHeight = icon.getIntrinsicHeight();

        // Calculate icon position
        int iconMargin = (itemHeight - iconHeight) / 2;
        int iconTop = itemView.getTop() + (itemHeight - iconHeight) / 2;
        int iconBottom = iconTop + iconHeight;
        int iconLeft, iconRight;

        if (dX > 0) { // Swiping to the right
            iconLeft = itemView.getLeft() + iconMargin;
            iconRight = itemView.getLeft() + iconMargin + iconWidth;
        } else { // Swiping to the left
            iconLeft = itemView.getRight() - iconMargin - iconWidth;
            iconRight = itemView.getRight() - iconMargin;
        }

        // Set icon bounds and draw
        icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);
        icon.draw(c);

        // Draw background
        background.setBounds(itemView.getLeft(), itemView.getTop(),
                itemView.getRight(), itemView.getBottom());
        background.draw(c);
    }
}
