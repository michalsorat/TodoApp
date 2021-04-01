package com.example.TodoApp.userNotes;

import com.example.TodoApp.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNoteRepository extends JpaRepository<UserNote, Long> {
}
