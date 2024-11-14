package com.demo.todo.service;

import com.demo.todo.entities.NoteEntity;
import com.demo.todo.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NoteService {
    private TaskService taskService;
    private HashMap<Long, TaskNotesHolder> taskNotesHolders = new HashMap<>();

    public NoteService(TaskService taskService) {
        this.taskService = taskService;
    }

    class TaskNotesHolder{
        protected int noteId = 1;
        protected ArrayList<NoteEntity> notes = new ArrayList<>();
    }

    public List<NoteEntity> getNotesForTask(Long taskId){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(! taskNotesHolders.containsKey(taskId)){
            taskNotesHolders.put(taskId, new TaskNotesHolder());
        }

        return taskNotesHolders.get(taskId).notes;
    }

    public NoteEntity addNoteForTask(Long taskId, String title, String body){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null) {
            return null;
        }
        if(taskNotesHolders.get(taskId) == null){
            taskNotesHolders.put(taskId, new TaskNotesHolder());
        }
        TaskNotesHolder taskNotesHolder = taskNotesHolders.get(taskId);
        NoteEntity note = new NoteEntity();
        note.setId(taskNotesHolder.noteId);
        note.setTitle(title);
        note.setBody(body);
        taskNotesHolder.notes.add(note);
        taskNotesHolder.noteId++;
        return note;
    }
}
