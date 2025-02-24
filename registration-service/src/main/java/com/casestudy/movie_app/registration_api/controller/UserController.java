package com.casestudy.movie_app.registration_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.movie_app.registration_api.entity.UserProfile;
import com.casestudy.movie_app.registration_api.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movie-app")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<Object> saveUser(@RequestBody UserProfile userProfile){
        if (userService.userExists(userProfile.getUsername())) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        try {
        	userService.createUser(userProfile);
            return ResponseEntity.status(HttpStatus.CREATED).body("User profile created successfully");
        }catch(Exception e) {
        	return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    	 
    }
    @GetMapping("/get-users")
    public List<UserProfile> getAllUsers(){
        return userService.getUsers();
    }
}
