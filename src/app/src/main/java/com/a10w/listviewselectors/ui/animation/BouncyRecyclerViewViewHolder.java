package com.a10w.listviewselectors.ui.animation;

import android.view.View;

import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.recyclerview.widget.RecyclerView;

public class BouncyRecyclerViewViewHolder extends RecyclerView.ViewHolder {
    public float currentVelocity = 0f;
    public final SpringAnimation translationY;

    public BouncyRecyclerViewViewHolder(View itemView) {
        super(itemView);
        translationY = AnimationHelpers.createSpringAnimation(itemView);
    }
}
