package com.example.TodoApp.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    //String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User laco = new User(
                    "laco",
                    "jamal123",
                    "laco@gmail.com"/*,
                    date*/
            );
            User michal = new User(
                    "michal",
                    "michal1234",
                    "michal@gmail.com"/*,
                    date*/
            );
            User sasalka = new User(
                    "sasalka",
                    "1234567",
                    "sss@gmail.com"/*,
                    date*/
            );
            repository.saveAll(
                    List.of(laco, michal, sasalka)
            );
        };
    }
}
