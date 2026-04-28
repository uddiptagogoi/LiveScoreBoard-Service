package com.LiveScoreBoardService.service;

import com.LiveScoreBoardService.entity.User;
import com.LiveScoreBoardService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(String id) {
        return repository.findById(id).orElse(null);
    }

    public User updateUser(String id, User user) {
        User existing = repository.findById(id).orElse(null);
        if (existing != null) {
//            existing.setName(user.getName());
//            existing.setEmail(user.getEmail());
            return repository.save(existing);
        }
        return null;
    }

    public String deleteUser(String id) {
        repository.deleteById(id);
        return "User deleted with id: " + id;
    }
}
