package com.example.TodoApp.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
public class UserConfig {

    String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User laco = new User(
                    "laco",
                    "jamal123",
                    "laco@gmail.com"
            );
            User michal = new User(
                    "michal",
                    "michal1234",
                    "michal@gmail.com"
            );
            repository.saveAll(
                    List.of(laco, michal)
            );
        };
    }
}
