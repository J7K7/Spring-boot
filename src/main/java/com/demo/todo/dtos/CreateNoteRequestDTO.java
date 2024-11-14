package com.demo.todo.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateNoteRequestDTO {
    private String title;
    private String body;
}
