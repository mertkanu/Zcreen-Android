package com.zcreen.core;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by mertkanuzunparmak on 22/02/16.
 * mertkan@mobilike.com
 */
public abstract class BaseRecyclerAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private ArrayList<Object> dataSet = new ArrayList<>();

    public Object removeItem(int position) {
        final Object object = dataSet.remove(position);
        notifyItemRemoved(position);

        return object;
    }

    public void addItem(int position, Object object) {
        dataSet.add(position, object);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final Object object = dataSet.remove(fromPosition);
        dataSet.add(toPosition, object);
        notifyItemMoved(fromPosition, toPosition);
    }

    public void animateTo(ArrayList<Object> objects) {
        applyAndAnimateRemovals(objects);
        applyAndAnimateAdditions(objects);
        applyAndAnimateMovedItems(objects);
    }

    private void applyAndAnimateRemovals(ArrayList<Object> newModels) {
        for (int i = dataSet.size() - 1; i >= 0; i--) {
            final Object model = dataSet.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(ArrayList<Object> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final Object model = newModels.get(i);
            if (!dataSet.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(ArrayList<Object> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final Object model = newModels.get(toPosition);
            final int fromPosition = dataSet.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }
}
