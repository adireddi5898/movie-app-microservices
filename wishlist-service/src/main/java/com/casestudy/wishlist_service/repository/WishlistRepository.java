package com.casestudy.wishlist_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.wishlist_service.entity.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
//	boolean existById(Integer Id);
}
