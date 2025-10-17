package com.example.smarttodolistapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Represents a single Task entity stored in the Room database.
 * Each task has an auto-generated ID, a title, completion status, and a creation date.
 */
@Entity(tableName = "tasks")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private boolean completed;
    private String date; // 🔹 New field for the date

    // ✅ Constructor simple
    public Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
        this.date = ""; // default empty date
    }

    // ✅ Constructor complet (optionnel)
    public Task(String title, boolean completed, String date) {
        this.title = title;
        this.completed = completed;
        this.date = date;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
