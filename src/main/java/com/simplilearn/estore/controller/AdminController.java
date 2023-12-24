package com.simplilearn.estore.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.estore.domain.HttpResponse;
import com.simplilearn.estore.jpa.Admin;
import com.simplilearn.estore.service.AdminService;

@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/admins")
public class AdminController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AdminService adminService;

    @PostMapping("/add")
    HttpResponse<Admin> addAdmin(@RequestBody Admin admin){

       logger.debug("Add Admin: {}", admin);

       this.adminService.saveAdmin(admin);

       return new HttpResponse<>(101, String.format("Admin Added Successfully at %tD",new Date()),List.of(admin));
    }

    @PostMapping("/login")
    HttpResponse<Admin> loginAdmin(@RequestBody Admin admin){

       logger.debug("Login Admin: {}", admin);

       Optional<Admin> opt = this.adminService.loginAdmin(admin);

       if (opt.isPresent()) {

           return new HttpResponse<>(101, String.format("Admin Logged In Successfully at %tD",new Date()),List.of(opt.get()));
       }
       else {
           return new HttpResponse<>(201, String.format("Admin Authentication Failed at %tD",new Date()),List.of(admin));
       }
   }
}
