package com.service.movieapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.movieapp.entity.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findAll();
}
