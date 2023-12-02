package com.simplilearn.estore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.estore.jpa.User;
import com.simplilearn.estore.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return this.userRepository.findById(id);
    }

    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

    public Optional<User> loginUser(User user) {
        return this.userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword())
                                      .stream().findAny();
    }
}
