package com.example.smarttodolistapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Represents a Task entity for the Room database.
 */
@Entity(tableName = "tasks")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private boolean completed;

    // ---- Constructeur ----
    public Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    // ---- Getters & Setters ----

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;   // <--- هذي اللي كان يطلبها Android Studio
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
