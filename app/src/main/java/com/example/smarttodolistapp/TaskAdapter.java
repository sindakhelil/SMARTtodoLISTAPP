package com.example.smarttodolistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final List<Task> taskList;

    public TaskAdapter(List<Task> tasks) {
        if (tasks != null) {
            this.taskList = tasks;
        } else {
            this.taskList = new ArrayList<>();
        }
    }

    public void addTask(Task task) {
        taskList.add(task);
        notifyItemInserted(taskList.size() - 1);
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
        Task task = taskList.get(position);
        holder.taskText.setText(task.getTitle());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }



    static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView taskText;

        TaskViewHolder(View itemView) {
            super(itemView);
            // تصحيح id هنا
            taskText = itemView.findViewById(R.id.tvTask);


        }
    }
}
