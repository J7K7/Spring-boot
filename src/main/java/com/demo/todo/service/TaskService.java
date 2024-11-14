package com.demo.todo.service;

import com.demo.todo.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.ParseException;

@Service
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private long taskId = 1;
    private final SimpleDateFormat deadlienFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public TaskEntity addTask(String title, String description, String deadline) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(deadlienFormatter.parse(deadline));
        task.setCompleted(false);
        taskId++;
        tasks.add(task);
        return task;
    }

    public ArrayList<TaskEntity> getTasks(){
        return tasks;
    }

    public TaskEntity getTaskById(Long Id){
        for(TaskEntity task : tasks) {
            if (task.getId() == Id) {
                return task;
            }
        }
        return null;
    }

    public TaskEntity updateTask(Long Id, String description, String deadline, Boolean completed) throws ParseException{
        TaskEntity task = getTaskById(Id);
        if(task == null){
            return null;
        }
        if(description != null) {
            task.setDescription(description);
        }
        if(deadline != null){
            task.setDeadline(deadlienFormatter.parse(deadline));
        }
        if(completed != null){
            task.setCompleted(completed);
        }
        return task;
    }
}
