package com.casestudy.wishlist_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.wishlist_service.entity.Wishlist;
import com.casestudy.wishlist_service.service.WishlistService;

@RestController
@RequestMapping("/movies/wishlist")
public class WishlistController {
	@Autowired
	private WishlistService wishlistService;

	@GetMapping("/all-wishlist-movies")
	public ResponseEntity<Optional<List<Wishlist>>> allWishList() {
		Optional<List<Wishlist>> wishlist = wishlistService.getwishlist();
		return ResponseEntity.ok(wishlist);
	}

	@PostMapping("/addtowishlist")
	public ResponseEntity<Object> toWishList(@RequestBody Wishlist wishlist) {
		wishlistService.addToWishlist(wishlist);
//		return ResponseEntity.status(HttpStatus.CREATED).body("Movie added successfully...!");
		return new ResponseEntity<Object>(wishlist, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteItemById(@PathVariable Integer id) {
		wishlistService.deleteById(id);
		return ResponseEntity.ok("Item deleted successfully");
	}

}
