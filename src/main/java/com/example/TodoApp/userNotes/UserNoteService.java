package com.example.TodoApp.userNotes;

import com.example.TodoApp.users.User;
import com.example.TodoApp.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserNoteService {
    private final UserNoteRepository userNotesRepository;

    @Autowired
    public UserNoteService(UserNoteRepository userNotesRepository) {
        this.userNotesRepository = userNotesRepository;
    }

    public List<UserNote> getUserNote(){
        return userNotesRepository.findAll();
    }

    public void addNewUserNote(UserNote userNote) {
        userNotesRepository.save(userNote);
    }

    public void deleteUserNote(Long id) {
        boolean exists = userNotesRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Note with id " + id + "does not exist");
        }
        userNotesRepository.deleteById(id);
    }
}
