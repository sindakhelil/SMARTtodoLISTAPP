package com.example.smarttodolistapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * MainActivity class handles the UI of the app.
 * It displays the list of tasks and allows adding new tasks.
 */
public class MainActivity extends AppCompatActivity {

    private TaskAdapter taskAdapter;
    private AppDatabase database;
    private EditText editTextTask;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextTask = findViewById(R.id.editTextTask);
        buttonAdd = findViewById(R.id.buttonAdd);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Initialize Room database
        database = AppDatabase.getInstance(this);

        // Load existing tasks from the database
        List<Task> tasks = database.taskDao().getAllTasks();

        // Initialize adapter with the task list
        taskAdapter = new TaskAdapter(tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(taskAdapter);

        // Handle the "Add Task" button click
        buttonAdd.setOnClickListener(v -> {
            String title = editTextTask.getText().toString().trim();
            if (!title.isEmpty()) {
                // Create and insert new task
                Task task = new Task(title, false);
                database.taskDao().insert(task);

                // Update RecyclerView
                taskAdapter.addTask(task);

                // Clear input field
                editTextTask.setText("");
            }
        });
    }
}
