package com.example.TodoApp.userNotes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNoteService {
    public List<UserNote> getUserNote(){
        return List.of(
                new UserNote(
                        1L,
                        1L
                )
        );
    }
}
