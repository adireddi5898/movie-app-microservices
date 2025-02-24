package com.casestudy.wishlist_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wishlist")
public class Wishlist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "gener")
	private String gener;
	@Column(name = "year")
	private int year;

	/*
	 * @Column(name = "title") private String title;
	 * 
	 * @Column(name = "rating") private double rating;
	 * 
	 * @Column(name = "year") private int year;
	 * 
	 * @Column(name = "imdbid") private String imdbid;
	 */
}