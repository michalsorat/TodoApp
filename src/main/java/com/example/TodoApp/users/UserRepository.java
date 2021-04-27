package com.example.TodoApp.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByName(String name);
}
