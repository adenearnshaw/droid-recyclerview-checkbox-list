package com.a10w.listviewselectors.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.a10w.listviewselectors.R;
import com.a10w.listviewselectors.models.ToDoItem;
import com.a10w.listviewselectors.ui.animation.BouncyRecyclerViewViewHolder;

import java.util.List;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder> {
    private List<ToDoItem> mItems;

    public ToDoListAdapter(List<ToDoItem> items) {
        super();
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View todoItemView = inflater.inflate(R.layout.list_row_todo_item, parent, false);

        return new ViewHolder(todoItemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ToDoItem toDoItem = mItems.get(position);

        holder.tv_description.setText(toDoItem.getDescription());
        holder.setSelected(toDoItem.getIsSelected());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder  extends BouncyRecyclerViewViewHolder implements View.OnClickListener {
        public final View v_container;
        public final TextView tv_description;
        public final CheckBox cb_isSelected;

        public ViewHolder(View itemView) {
            super(itemView);

            v_container = itemView.findViewById(R.id.container_todo_item);
            tv_description = (TextView) itemView.findViewById(R.id.textView);
            cb_isSelected = (CheckBox) itemView.findViewById(R.id.checkBox);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            setSelected(!cb_isSelected.isChecked());
        }

        public void setSelected(boolean isSelected) {
            int position = getAdapterPosition();
            mItems.get(position).setIsSelected(isSelected);
            v_container.setSelected(isSelected);
            cb_isSelected.setChecked(isSelected);
        }
    }
}
