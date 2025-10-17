package com.example.smarttodolistapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Represents a single Task entity stored in the Room database.
 * Each task has an auto-generated ID, a title, and a completion status.
 */
@Entity(tableName = "tasks")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private boolean completed;

    // Constructor
    public Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
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
    private String date; // format: "dd/MM/yyyy"

    public Task(String title, boolean completed, String date) {
        this.title = title;
        this.completed = completed;
        this.date = date;
    }

    // getter et setter
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

}
