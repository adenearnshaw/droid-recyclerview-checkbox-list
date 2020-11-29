package com.a10w.listviewselectors.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.a10w.listviewselectors.R;
import com.a10w.listviewselectors.models.ToDoItem;
import com.a10w.listviewselectors.ui.adapters.ToDoListAdapter;
import com.a10w.listviewselectors.ui.helpers.RecyclerViewHelpers;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ToDoItem> todoItems = new ArrayList<ToDoItem>();
        todoItems.add((new ToDoItem("Item 1")));
        todoItems.add((new ToDoItem("Item 2")));
        todoItems.add((new ToDoItem("Item 3")));
        todoItems.add((new ToDoItem("Item 4")));
        todoItems.add((new ToDoItem("Item 5")));
        todoItems.add((new ToDoItem("Item 6")));
        todoItems.add((new ToDoItem("Item 7")));
        todoItems.add((new ToDoItem("Item 8")));
        todoItems.add((new ToDoItem("Item 9")));
        todoItems.add((new ToDoItem("Item 10")));
        todoItems.add((new ToDoItem("Item 11")));
        todoItems.add((new ToDoItem("Item 12")));
        todoItems.add((new ToDoItem("Item 13")));
        todoItems.add((new ToDoItem("Item 14")));
        todoItems.add((new ToDoItem("Item 15")));
        todoItems.add((new ToDoItem("Item 16")));
        todoItems.add((new ToDoItem("Item 17")));
        todoItems.add((new ToDoItem("Item 18")));
        todoItems.add((new ToDoItem("Item 19")));
        todoItems.add((new ToDoItem("Item 20")));

        ToDoListAdapter adapter = new ToDoListAdapter(todoItems);
        RecyclerViewHelpers.setupRecyclerViewAsList(this, R.id.main_todo_rv, adapter);
    }
}