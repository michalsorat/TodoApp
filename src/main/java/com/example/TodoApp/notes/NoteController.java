package com.example.TodoApp.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getNote() {
        return noteService.getNotes();
    }

    @PostMapping(path = "newNote")
    public void addNewNote(@RequestBody Note note) {
        noteService.addNewNote(note);
    }

    @DeleteMapping(path = "{noteID}")
    public void deleteNote(@PathVariable("noteID") Long noteID) {
        noteService.deleteNote(noteID);
    }

    @PutMapping(path = "{noteID}")
    public void updateNote(
            @PathVariable("noteID") Long noteID,
            @RequestParam(required = false) String note,
            @RequestParam(required = false) Boolean favourite) {
        noteService.updateNote(noteID, note, favourite);

    }

}
