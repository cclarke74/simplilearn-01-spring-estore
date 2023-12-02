package com.simplilearn.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.estore.jpa.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
