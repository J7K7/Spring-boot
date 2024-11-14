package com.demo.todo.controller;

import com.demo.todo.dtos.CreateNoteRequestDTO;
import com.demo.todo.dtos.CreateNoteResponseDTO;
import com.demo.todo.entities.NoteEntity;
import com.demo.todo.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {
    private final NoteService noteService;

    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Long id){
        var notes = noteService.getNotesForTask(id);
        return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<CreateNoteResponseDTO> addNotes(@PathVariable("taskId") Long id, @RequestBody CreateNoteRequestDTO body){
        var note = noteService.addNoteForTask(id, body.getTitle(), body.getBody());
        return ResponseEntity.ok(new CreateNoteResponseDTO(id, note));
    }
}
