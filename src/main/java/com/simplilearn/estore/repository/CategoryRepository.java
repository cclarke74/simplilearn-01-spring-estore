package com.simplilearn.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.estore.jpa.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
