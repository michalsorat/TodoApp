package com.example.TodoApp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public User getUser(
            @PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userID}")
    public void deleteUser(@PathVariable("userID") Long userID) {
        userService.deleteUser(userID);
    }

    @PutMapping(path = "{userID}")
    public void updateUser(
            @PathVariable("userID") Long userID,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password) {
        userService.updateUser(userID, name, email, password);

    }

    @GetMapping
    public User loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }
}
