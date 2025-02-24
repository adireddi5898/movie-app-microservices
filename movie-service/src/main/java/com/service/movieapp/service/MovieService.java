package com.service.movieapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.movieapp.entity.Movie;
import com.service.movieapp.repo.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private RestTemplate restTemplate;
	private final String apiKey = "x-rapidapi-key";
	private final String apiKeyValue = "d626a8071emsh38bd5a5a6862008p124091jsn9f6d9b85f322";
	private final String url = "https://imdb-top-100-movies.p.rapidapi.com/";

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public List<Movie> fetchMoviesAndSave() {
		List<Movie> movies = fetchMovies();
		if (movies != null && !movies.isEmpty()) {
			movieRepository.saveAll(movies);
		}
		return movies;
	}

	public List<Movie> fetchMovies() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("x-rapidapi-key", "d626a8071emsh38bd5a5a6862008p124091jsn9f6d9b85f322");
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<Movie[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Movie[].class);
		return Arrays.asList(response.getBody());
	}
}