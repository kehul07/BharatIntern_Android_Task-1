package com.kehuldroid.todoapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> taskList;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter(taskList);

        RecyclerView recyclerViewTasks = findViewById(R.id.taskRecyclerView);
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTasks.setAdapter(taskAdapter);

        EditText editTextTask = findViewById(R.id.task);
        Button buttonAdd = findViewById(R.id.add);

        buttonAdd.setOnClickListener(v -> {
            String taskName = editTextTask.getText().toString();
            if (!taskName.isEmpty()) {
                taskList.add(new Task(taskName));
                taskAdapter.notifyItemInserted(taskList.size() - 1);
                editTextTask.setText("");
            }
        });
    }
}
