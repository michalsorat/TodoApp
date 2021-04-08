package com.example.TodoApp.notes;

import com.example.TodoApp.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    @ResponseStatus(HttpStatus.OK)
    public List<Note> getNotesOfUser(@PathVariable("userId") long userId) {
        return noteService.getNotesByUser(userId);
    }

    //vybrat jeden note podla id
    @GetMapping(path = "{noteId}")
    @ResponseStatus(HttpStatus.OK)
    public Note getNote(@PathVariable("noteId") long noteId){
        try {
            return noteService.getNote(noteId);
        }
        catch(IllegalStateException exc){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        }
    }


    @PostMapping(path = "newNote")
    @ResponseStatus(HttpStatus.OK)
    public Note addNewNote(@RequestBody Note newNote) {
        try {
            return noteService.addNewNote(newNote);
        }
        catch (IllegalStateException exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        }
    }

    @DeleteMapping(path = "{noteID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNote(@PathVariable("noteID") long noteID) {
        try {
            noteService.deleteNote(noteID);
        }
        catch (IllegalStateException exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        }
    }

    @PutMapping(path = "{noteID}")
    @ResponseStatus(HttpStatus.OK)
    public Note updateNote(@PathVariable("noteID") long noteID, @RequestBody Note noteUpd) {
        try {
            return noteService.updateNote(noteID, noteUpd);
        }
        catch (IllegalStateException exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        }
    }
}
