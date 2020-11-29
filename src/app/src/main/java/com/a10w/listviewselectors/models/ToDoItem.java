package com.a10w.listviewselectors.models;

import java.util.UUID;

public class ToDoItem {
    private final UUID mID;
    private boolean mIsSelected = false;
    private String mDescription;

    public ToDoItem(String description) {
        mID = UUID.randomUUID();
        mDescription = description;
    }

    public UUID getID() { return mID; }

    public boolean getIsSelected() { return mIsSelected; }
    public void setIsSelected(boolean isSelected) { mIsSelected = isSelected; }

    public String getDescription() { return mDescription; }
    public void setDescription(String description) { mDescription = description; }
}
