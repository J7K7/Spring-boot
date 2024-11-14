package com.demo.todo.dtos;

import com.demo.todo.entities.NoteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class TaskResponseDTO {
    private long id;
    private String title;
    private String description;
    private Date deadline;
    private boolean completed;
    private List<NoteEntity> noteList;
}
