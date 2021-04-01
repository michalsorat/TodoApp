package com.example.TodoApp.userNotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/userNotes")
public class UserNoteController {

    private final UserNoteService userNoteService;

    @Autowired
    public UserNoteController(UserNoteService userNoteService) {
        this.userNoteService = userNoteService;
    }

    @GetMapping
    public List<UserNote> getUserNote(){
        return userNoteService.getUserNote();
    }
}
