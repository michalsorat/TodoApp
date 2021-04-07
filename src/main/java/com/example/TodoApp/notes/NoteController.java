package com.example.TodoApp.notes;

import com.example.TodoApp.users.User;
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

    //get notes pre daneho usera
    @GetMapping(path = "user/{userId}")
    public List<Note> getNotes(@PathVariable("userId") long userId) {
        return noteService.getNotesByUser(userId);
    }

    //vybrat jeden note podla id
    @GetMapping(path = "{noteId}")
    public Note getNote(@PathVariable("noteId") long noteId){
        return noteService.getNote(noteId);
    }

    @PostMapping(path = "newNote")
    public void addNewNote(@RequestBody Note note) {
        noteService.addNewNote(note);
    }

    @DeleteMapping(path = "{noteID}")
    public void deleteNote(@PathVariable("noteID") long noteID) {
        noteService.deleteNote(noteID);
    }

    @PutMapping(path = "{noteID}")
    public void updateNote(
            @PathVariable("noteID") long noteID,
            @RequestParam(required = false) String note,
            @RequestParam(required = false) Boolean favourite) {
        noteService.updateNote(noteID, note, favourite);

    }

}
