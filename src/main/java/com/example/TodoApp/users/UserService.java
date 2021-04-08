package com.example.TodoApp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addNewUser(User user) {
        if (user.getPassword() != null && user.getEmail() != null && user.getName() != null &&
                !user.getPassword().isEmpty() && !user.getEmail().isEmpty() && !user.getName().isEmpty()) {
            if (user.getPassword().length() <= 6) {
                throw new IllegalArgumentException("Password too short");
            }
            //kontrola mena a hesla
            Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
            if (userByEmail.isPresent()) {
                throw new IllegalArgumentException("Email address already in use");
            }
            Optional<User> userByName = userRepository.findUserByName((user.getName()));
            if (userByName.isPresent()) {
                throw new IllegalArgumentException("Name already in use");
            }

            user.setReg_date(LocalDate.now());
            userRepository.save(user);
            return user;
        }
        else
        {
            throw new IllegalStateException("Missing input");
        }
    }

    public void deleteUser(long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalStateException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public User updateUser(long userID, User userUpt) {
        if (userRepository.findById(userID).isPresent())
        {
            User existingUser = userRepository.findById(userID).get();
            if (userUpt.getName() != null && !Objects.equals(existingUser.getName(), userUpt.getName())) {
                existingUser.setName(userUpt.getName());
            }
            if (userUpt.getPassword() != null && !Objects.equals(existingUser.getPassword(), userUpt.getPassword())) {
                if (userUpt.getPassword().length() > 6)
                    existingUser.setPassword(userUpt.getPassword());
                else
                    throw new IllegalArgumentException("Email already in use");
            }
            if (userUpt.getEmail() != null && !Objects.equals(existingUser.getEmail(), userUpt.getEmail())) {
                Optional<User> userMail = userRepository.findUserByEmail(userUpt.getEmail());
                if (userMail.isPresent()) {
                    throw new IllegalArgumentException("Email already in use");
                }
                existingUser.setEmail(userUpt.getEmail());
            }
            return userRepository.save(existingUser);
        }
        else
        {
            throw new IllegalStateException("User with id " + userID + " does not exist");
        }
    }

    public User getUser(long userId) {
        Optional<User> exists = userRepository.findById(userId);
        if (exists.isEmpty())
            throw new IllegalStateException("User with ID " + userId + " does not exist!");
        return exists.get();
    }

    public User loginUser(User user) {
        if (user != null && user.getEmail() != null && user.getPassword() != null && !user.getPassword().isEmpty() && !user.getEmail().isEmpty()) {
            Optional<User> exists = userRepository.findUserByEmail(user.getEmail());
            if (exists.isPresent() && !user.getPassword().equals(exists.get().getPassword())) {
                throw new IllegalArgumentException("Wrong email or password");
            }
            else if (exists.isEmpty())
                throw new IllegalStateException("Wrong email or password");
            else
                return exists.get();
        }
        else
            throw new IllegalStateException("Missing input");
    }
}
