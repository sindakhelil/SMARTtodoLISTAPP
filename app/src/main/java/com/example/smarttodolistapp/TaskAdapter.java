package com.example.smarttodolistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Adapter pour gérer l'affichage et les actions sur les tâches.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks;
    private AppDatabase db;

    // Constructeur
    public TaskAdapter(List<Task> tasks, AppDatabase db) {
        this.tasks = tasks;
        this.db = db;
    }

    // Permet d’ajouter une nouvelle tâche à la liste
    public void addTask(Task newTask) {
        tasks.add(newTask);
        notifyItemInserted(tasks.size() - 1);
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.checkBox.setText(task.getTitle());
        holder.textDate.setText(task.getDate());
        holder.checkBox.setChecked(task.isCompleted());

        // Action supprimer
        holder.buttonDelete.setOnClickListener(v -> {
            db.taskDao().delete(task);
            int pos = holder.getAdapterPosition();
            tasks.remove(pos);
            notifyItemRemoved(pos);
        });

        // Action cocher / décocher
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.setCompleted(isChecked);
            db.taskDao().update(task);
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    // ViewHolder
    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView textDate;
        Button buttonDelete;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBoxTask);
            textDate = itemView.findViewById(R.id.tvDate);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
