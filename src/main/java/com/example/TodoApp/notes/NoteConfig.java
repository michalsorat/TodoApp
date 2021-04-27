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
                    "2021-03-28",
                    "2021-04-29",
                    true

            );
            Note todo2 = new Note(
                    2,2,"NoteName2",
                    "descriptionNote2",
                    "2021-03-28",
                    "2021-04-29",
                    false

            );
            Note todo3 = new Note(
                    3,1,
                    "NoteName3",
                    "descriptionNote3",
                    "2021-03-28",
                    "2021-04-28",
                    false
            );
            repository.saveAll(
                    List.of(todo1, todo2, todo3)
            );
        };
    }
}
