package com.demo.todo.dtos;

import com.demo.todo.entities.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateNoteResponseDTO {
    private Long taskId;
    private NoteEntity noteEntity;
}
