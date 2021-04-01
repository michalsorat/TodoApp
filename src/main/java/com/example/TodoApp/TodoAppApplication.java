package com.example.TodoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class TodoAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(TodoAppApplication.class, args);
	}
}
