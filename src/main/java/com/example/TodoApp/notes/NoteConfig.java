package com.example.TodoApp.notes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class NoteConfig {

    @Bean
    CommandLineRunner commandLineRunner_Notes(NoteRepository repository){
        return args -> {
            Note todo = new Note(
                    "todo",
                    "from",
                    "to",
                    true
            );
            Note todo2 = new Note(
                    "todo2",
                    "from2",
                    "to2",
                    false
            );
            repository.saveAll(
                    List.of(todo, todo2)
            );
        };
    }
}
