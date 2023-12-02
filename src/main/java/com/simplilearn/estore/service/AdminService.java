package com.simplilearn.estore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.estore.jpa.Admin;
import com.simplilearn.estore.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public void saveAdmin(Admin admin) {
        this.adminRepository.save(admin);
    }

    public Optional<Admin> loginAdmin(Admin admin) {
        return this.adminRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword())
                                      .stream().findAny();
    }
}
