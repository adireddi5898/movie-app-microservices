package com.service.movieapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	@Id
	@Column(name = "rank_position")
	private Integer rank;
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "image")
	private String image;
	@Column(name = "big_image")
	private String bigImage;
	@Column(name = "thumbnail")
	private String thumbnail;
	@Column(name = "genre")
	private List<String> genre;
	private double rating;
	@Column(name = "year")
	private String year;
	@Column(name = "id")
	private String id;
	@Column(name = "imdb_id")
	private String imdbid;
	@Column(name = "imdb_link")
	private String imdbLink;
}