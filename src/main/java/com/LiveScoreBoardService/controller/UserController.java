package com.LiveScoreBoardService.controller;

import com.LiveScoreBoardService.entity.User;
import com.LiveScoreBoardService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    // POST
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    // GET all
    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    // GET by id
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return service.getUserById(id);
    }

    // PUT (update)
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        return service.deleteUser(id);
    }
}