package com.simplilearn.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.estore.jpa.Orderitem;

@Repository
public interface OrderitemRepository extends JpaRepository<Orderitem,Integer> {

}
