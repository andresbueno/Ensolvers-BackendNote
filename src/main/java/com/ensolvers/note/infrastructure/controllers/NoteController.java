package com.ensolvers.note.infrastructure.controllers;

import com.ensolvers.note.application.NoteService;
import com.ensolvers.note.domain.model.Note;
import com.ensolvers.note.infrastructure.dto.NoteRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin
@Tag(name="Notes", description="Controller to handle notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    @Operation(summary = "Method to create note")
    public Note createNote(@RequestBody NoteRequest request){
        return noteService.createNote(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Method to delete a note")
    public String deleteNote(@PathVariable Long id){
        return noteService.deleteNote(id);
    }

    @PatchMapping("/{id}")
    public String editNote(@RequestBody NoteRequest request, @PathVariable Long id){
        return noteService.editNote(id, request);
    }

    @GetMapping
    public List<Note> listNotes(@RequestParam(required = false) Boolean archived){
        return noteService.listNotes(archived);
    }

    @PatchMapping("/switch-status/{id}")
    @Operation(summary = "Method to  a note")
    public String archiveNote(@PathVariable Long id){
        return noteService.archiveNote(id);
    }
}
