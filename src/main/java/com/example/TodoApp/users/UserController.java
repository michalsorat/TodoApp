package com.example.TodoApp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUsers();
    }

    //vybrat jedneho usera podla id
    @GetMapping(path = "{userId}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable("userId") long userId) {
        try {
            return userService.getUser(userId);
        }
        catch (IllegalStateException exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        }
    }

    @PostMapping(path = "register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerNewUser(@RequestBody User user) {
        try{
            return userService.addNewUser(user);
        }
        catch (IllegalArgumentException exc) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, exc.getMessage(), exc);
        }
        catch (IllegalStateException exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        }
    }

    @DeleteMapping(path = "{userID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("userID") Long userID) {
        try {
            userService.deleteUser(userID);
        }
        catch (IllegalStateException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        }
    }

    @PutMapping(path = "{userID}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable("userID") Long userID, @RequestBody User userUpt) {
        try {
            return userService.updateUser(userID, userUpt);
        }
        catch (IllegalStateException exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        }
        catch (IllegalArgumentException exc) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, exc.getMessage(), exc);
        }
    }

    @PostMapping(path = "login")
    @ResponseStatus(HttpStatus.OK)
    public User loginUser(@RequestBody User user) {
        try {
            return userService.loginUser(user);
        }
        catch (IllegalArgumentException exc) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, exc.getMessage(), exc);
        }
        catch (IllegalStateException exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        }
    }
}
