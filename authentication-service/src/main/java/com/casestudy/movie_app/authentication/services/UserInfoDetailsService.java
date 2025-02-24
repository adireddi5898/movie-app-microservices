package com.casestudy.movie_app.authentication.services;

import com.casestudy.movie_app.authentication.config.UserInfoDetails;
import com.casestudy.movie_app.authentication.entity.User;
import com.casestudy.movie_app.authentication.repo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = repository.findByUsername(username);
        return userInfo.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}