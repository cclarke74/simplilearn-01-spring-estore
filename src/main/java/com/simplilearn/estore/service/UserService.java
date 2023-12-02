package com.simplilearn.estore.service;

import java.util.List;

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
}
