package com.simplilearn.estore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.estore.jpa.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    public List<Admin> findByEmailAndPassword(String email, String password);
}
