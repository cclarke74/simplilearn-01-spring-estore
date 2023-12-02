package com.simplilearn.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.estore.jpa.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist,Integer> {

}
