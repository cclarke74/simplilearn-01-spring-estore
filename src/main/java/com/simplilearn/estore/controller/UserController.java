package com.simplilearn.estore.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    HttpResponse<User> getUsers(){

        logger.debug("Get Users");

        List<User> users = this.userService.getUsers();

        return new HttpResponse<>(101, String.format("Users Fetched Successfully at %tD",new Date()),users);
    }

    @GetMapping("/get/{id}")
    HttpResponse<User> getUser(@PathVariable int id){

        logger.debug("Get User, userId: {}", id);

        Optional<User> opt = this.userService.getUser(id);

        if (opt.isPresent()) {

            return new HttpResponse<>(101, String.format("User Fetched Successfully at %tD",new Date()),List.of(opt.get()));
        }
        else {
            return new HttpResponse<>(201, String.format("User was not Found at %tD",new Date()),null);
        }
    }

    @DeleteMapping("/delete/{id}")
    HttpResponse<User> deleteUser(@PathVariable int id){

        logger.debug("Delete User, userId: {}", id);

        Optional<User> opt = this.userService.getUser(id);

        if (opt.isPresent()) {

            this.userService.deleteUser(opt.get());
            return new HttpResponse<>(101, String.format("User Deleted Successfully at %tD",new Date()),null);
        }
        else {
            return new HttpResponse<>(201, String.format("User was not Found at %tD",new Date()),null);
        }
    }

    @PostMapping("/login")
    HttpResponse<User> loginUser(@RequestBody User user){

       logger.debug("Login User: {}", user);

       Optional<User> opt = this.userService.loginUser(user);

       if (opt.isPresent()) {

           return new HttpResponse<>(101, String.format("User Logged In Successfully at %tD",new Date()),List.of(opt.get()));
       }
       else {
           return new HttpResponse<>(201, String.format("User Authentication Failed at %tD",new Date()),List.of(user));
       }
   }


}
