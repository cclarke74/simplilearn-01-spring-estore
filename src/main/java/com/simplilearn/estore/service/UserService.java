package com.simplilearn.estore.service;

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
}
