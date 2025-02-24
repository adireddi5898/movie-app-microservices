package com.casestudy.movie_app.authentication.services;

import com.casestudy.movie_app.authentication.entity.User;
import com.casestudy.movie_app.authentication.repo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getUsers() {

        return repository.findAll();
    }
    public User getUser(int id) {
        Optional<User> data = repository.findById(id);
        if (data.isPresent()) {
            return data.get();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
    public String loginUser(User userLoginData) {
        userLoginData.setPassword(passwordEncoder.encode(userLoginData.getPassword()));
        repository.save(userLoginData);
        return "Login Successfull!";
    }
}
