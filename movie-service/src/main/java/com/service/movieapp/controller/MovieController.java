package com.service.movieapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.movieapp.entity.Movie;
import com.service.movieapp.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/fetchandsave")
	public ResponseEntity<List<Movie>> allmovies() {
		List<Movie> movies = movieService.fetchMoviesAndSave();
		if (movies == null || movies.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(movies);
	}

	@GetMapping("/top100movies")
	public ResponseEntity<List<Movie>> top100movies() {
		List<Movie> movies = movieService.fetchMovies();
		return ResponseEntity.ok(movies);
	}
}
