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
    public List<Note> getNotes(@PathVariable("userId") long userId) {
        return noteService.getNotesByUser(userId);
    }

    //vybrat jeden note podla id
    @GetMapping(path = "{noteId}")
    public ResponseEntity<Note> getNote(@PathVariable("noteId") long noteId){
        Note retNote = noteService.getNote(noteId);
        if (retNote != null){
            return new ResponseEntity<>(retNote, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "newNote")
    @ResponseStatus(HttpStatus.OK)
    public Note addNewNote(@RequestBody Note newNote) {
        noteService.addNewNote(newNote);
        return newNote;
    }

    @DeleteMapping(path = "{noteID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNote(@PathVariable("noteID") long noteID) {
        if(!noteService.deleteNote(noteID))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Note with this id doesnt exist");
    }

    @PutMapping(path = "{noteID}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Note> updateNote(@PathVariable("noteID") long noteID, @RequestBody Note noteUpd) {
        if (noteService.updateNote(noteID, noteUpd) != null)
            return new ResponseEntity<>(noteUpd, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
