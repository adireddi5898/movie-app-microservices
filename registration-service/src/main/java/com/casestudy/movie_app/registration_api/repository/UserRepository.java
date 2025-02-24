package com.casestudy.movie_app.registration_api.repository;

import com.casestudy.movie_app.registration_api.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Integer> {
    Optional<UserProfile> findByUsername(String username);
}
