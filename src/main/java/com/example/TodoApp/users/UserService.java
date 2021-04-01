package com.example.TodoApp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if (userByEmail.isPresent()){
            throw new IllegalStateException("Email address already in use");
        }
        Optional<User> userByName = userRepository.findUserByName((user.getName()));
        if (userByName.isPresent()){
            throw new IllegalStateException("Name already in use");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("User with id " + id + "does not exist");
        }
        userRepository.deleteById(id);
    }
    @Transactional
    public void updateUser(Long userID, String name, String email, String password){
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new IllegalStateException("User with ID " + userID + "does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)){
            user.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)){
            Optional<User> userMail = userRepository
                    .findUserByEmail(email);
            if (userMail.isPresent()){
                throw new IllegalStateException("Email already in use");
            }
            user.setEmail(email);
        }
        if (password != null && password.length() > 6 && !Objects.equals(user.getPassword(), password)){
            user.setPassword(password);
        }
    }
}
