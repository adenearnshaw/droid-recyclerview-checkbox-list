package com.a10w.listviewselectors.ui.animation;

import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Color;
import android.os.Build;
import android.widget.EdgeEffect;

import androidx.recyclerview.widget.RecyclerView;

import com.a10w.listviewselectors.ui.helpers.RecyclerViewHelpers;

import static androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory.DIRECTION_BOTTOM;

public class RecyclerViewBounceEffect extends EdgeEffect {
    private final float OVERSCROLL_TRANSLATION_MAGNITUDE = 0.2f;
    private final float FLING_TRANSLATION_MAGNITUDE = 0.5f;

    private final RecyclerView mRecyclerView;
    private final int mDirection;

    public RecyclerViewBounceEffect(Context context, RecyclerView recyclerView, int direction) {
        super(context);
        mRecyclerView = recyclerView;
        mDirection = direction;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            this.setBlendMode(BlendMode.COLOR);
        }
        setColor(Color.TRANSPARENT);
    }

    @Override
    public void onPull(float deltaDistance) {
        super.onPull(deltaDistance);
        handlePull(deltaDistance);
    }

    @Override
    public void onPull(float deltaDistance, float displacement) {
        super.onPull(deltaDistance, displacement);
        handlePull(deltaDistance);
    }

    private void handlePull(float deltaDistance) {
        int sign = mDirection == DIRECTION_BOTTOM ? -1 : 1;
        float translationYDelta = sign * mRecyclerView.getWidth() * deltaDistance * OVERSCROLL_TRANSLATION_MAGNITUDE;
        RecyclerViewHelpers.forEachVisibleHolder(mRecyclerView, (BouncyRecyclerViewViewHolder holder) -> {
            if (holder == null)
                return null;

            holder.translationY.cancel();
            holder.itemView.setTranslationY(holder.itemView.getTranslationY() + translationYDelta);
            return null;
        });
    }

    @Override
    public void onRelease() {
        super.onRelease();
        RecyclerViewHelpers.forEachVisibleHolder(mRecyclerView, (BouncyRecyclerViewViewHolder holder) -> {
            if (holder == null)
                return null;

            holder.translationY.start();
            return null;
        });
    }

    @Override
    public void onAbsorb(int velocity) {
        super.onAbsorb(velocity);
        float sign = mDirection == DIRECTION_BOTTOM ? -1 : 1;
        float translationVelocity = sign * velocity * FLING_TRANSLATION_MAGNITUDE;
        RecyclerViewHelpers.forEachVisibleHolder(mRecyclerView, (BouncyRecyclerViewViewHolder holder) -> {
            if (holder == null)
                return null;

            holder.translationY.setStartVelocity(translationVelocity).start();
            return null;
        });
    }
}
