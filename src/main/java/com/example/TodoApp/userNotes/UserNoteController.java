package com.example.TodoApp.userNotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/userNotes")
public class UserNoteController {

    private final UserNoteService userNoteService;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private String userId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "noteId", nullable = false)
    private String noteId;

    @Autowired
    public UserNoteController(UserNoteService userNoteService) {
        this.userNoteService = userNoteService;
    }

    @GetMapping
    public List<UserNote> getUserNote() {
        return userNoteService.getUserNote();
    }

    @PostMapping
    public void newNote(@RequestBody UserNote userNote) {
        userNoteService.addNewUserNote(userNote);
    }

    @DeleteMapping(path = "{userNoteID}")
    public void deleteUser(@PathVariable("userNoteID") Long userNoteID) {
        userNoteService.deleteUserNote(userNoteID);
    }
}
