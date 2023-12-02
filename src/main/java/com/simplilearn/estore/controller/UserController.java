package com.simplilearn.estore.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.estore.domain.HttpResponse;
import com.simplilearn.estore.jpa.User;
import com.simplilearn.estore.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @PostMapping("/add")
    HttpResponse<User> addUser(@RequestBody User user){

       logger.debug("Add User: {}", user);

       this.userService.saveUser(user);

       return new HttpResponse<>(101, String.format("User Added Successfully at %tD",new Date()),List.of(user));
    }

    @PutMapping("/update")
    HttpResponse<User> updateUser(@RequestBody User user){

        logger.debug("Update User: {}", user);

        this.userService.saveUser(user);

        return new HttpResponse<>(101, String.format("User Updated Successfully at %tD",new Date()),List.of(user));
    }

    @GetMapping("/get")
    HttpResponse<User> getsUsers(){

        logger.debug("Get Users");

        List<User> users = this.userService.getUsers();

        return new HttpResponse<>(101, String.format("Users Fetched Successfully at %tD",new Date()),users);
    }


}
