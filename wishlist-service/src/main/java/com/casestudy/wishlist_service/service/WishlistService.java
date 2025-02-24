package com.casestudy.wishlist_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.wishlist_service.entity.Wishlist;
import com.casestudy.wishlist_service.repository.WishlistRepository;

@Service
public class WishlistService {
	@Autowired
	private WishlistRepository wishlistRepository;

	public Optional<List<Wishlist>> getwishlist() {
		return Optional.of(wishlistRepository.findAll());
	}

	public Wishlist addToWishlist(Wishlist wishlist) {
		return wishlistRepository.save(wishlist);
	}

	public void deleteById(Integer id) {
		wishlistRepository.deleteById(id);
	}

}
