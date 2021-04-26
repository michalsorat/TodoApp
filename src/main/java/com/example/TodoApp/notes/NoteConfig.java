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
                    1,1,
                    "noteName1",
                    "descriptionOfNote",
                    "28-03-2021",
                    "29-04-2021",
                    true

            );
            Note todo2 = new Note(
                    2,2,"NoteName2",
                    "descriptionNote2",
                    "28-03-2021",
                    "29-04-2021",
                    false

            );
            Note todo3 = new Note(
                    3,1,
                    "NoteName3",
                    "descriptionNote3",
                    "28-03-2021",
                    "28-04-2021",
                    false
            );
            repository.saveAll(
                    List.of(todo1, todo2, todo3)
            );
        };
    }
}
