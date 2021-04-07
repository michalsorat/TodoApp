package com.example.TodoApp.notes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class NoteConfig {

    @Bean
    CommandLineRunner commandLineRunner_Notes(NoteRepository repository) {
        return args -> {
            Note todo1 = new Note(
                    "noteName1",
                    "descriptionOfNote",
                    "from1",
                    "to1",
                    true
            );
            Note todo2 = new Note(
                    "NoteName2",
                    "descriptionNote2",
                    "from2",
                    "to2",
                    false
            );
            Note todo3 = new Note(
                    "NoteName3",
                    "descriptionNote3",
                    "from2",
                    "to2",
                    false
            );
            repository.saveAll(
                    List.of(todo1, todo2, todo3)
            );
        };
    }
}
