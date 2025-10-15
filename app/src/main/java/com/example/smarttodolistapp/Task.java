package com.example.smarttodolistapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks") // Nom de la table dans la base de données
public class Task {

    @PrimaryKey(autoGenerate = true) // ID unique qui s'incrémente automatiquement
    public int id;

    public String title;  // Le titre de la tâche
    public boolean completed; // Si la tâche est terminée ou non

    // Constructeur pour créer une nouvelle tâche
    public Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }
}
