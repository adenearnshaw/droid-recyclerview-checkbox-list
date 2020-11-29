package com.a10w.listviewselectors.ui.helpers;

import android.app.Activity;
import android.widget.EdgeEffect;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.a10w.listviewselectors.ui.animation.RecyclerViewBounceEffect;

import java.util.function.Function;

public class RecyclerViewHelpers {
    public static RecyclerView setupRecyclerViewAsList(Activity context, int recyclerViewId, RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = context.findViewById(recyclerViewId);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RecyclerViewHelpers.setBounceEnabled(recyclerView, true);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        return recyclerView;
    }

    public static <T> void forEachVisibleHolder(RecyclerView recyclerView, Function<T, Void> func) {
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            T item = ((T)recyclerView.getChildViewHolder(recyclerView.getChildAt(i)));
            func.apply(item);
        }
    }

    public static void setBounceEnabled(RecyclerView recyclerView, boolean isEnabled) {
        if (isEnabled) {
            recyclerView.setEdgeEffectFactory(new RecyclerView.EdgeEffectFactory() {
                @Override
                protected EdgeEffect createEdgeEffect(RecyclerView view, int direction) {
                    return new RecyclerViewBounceEffect(view.getContext(), view, direction);
                }
            });
        } else {
            recyclerView.setEdgeEffectFactory(null);
        }
    }
}
