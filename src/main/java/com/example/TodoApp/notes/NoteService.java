package com.example.TodoApp.notes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    public List<Note> getNotes(){
        return List.of(
                new Note(
                       1L,
                       "Toto je prva poznamka",
                       "04-01-2020",
                       "04-20-2020",
                       true
                )
        );
    }
}
