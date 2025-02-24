package com.casestudy.movie_app.authentication.repo;

import com.casestudy.movie_app.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserInfoRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
