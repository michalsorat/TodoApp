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
            Note todo = new Note(
                    "123",
                    "from",
                    "to",
                    true,
                    2
            );
            Note todo2 = new Note(
                    "sme najlepsi",
                    "from2",
                    "to2",
                    false,
                    2
            );
            repository.saveAll(
                    List.of(todo, todo2)
            );
        };
    }
}
