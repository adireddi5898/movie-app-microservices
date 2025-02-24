package com.casestudy.movie_app.registration_api.service;

import com.casestudy.movie_app.registration_api.entity.UserProfile;
import com.casestudy.movie_app.registration_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
    @Autowired
    private KafkaProducer kafkaProducer;


    public boolean userExists(String email) {
        return userRepository.findByUsername(email).isPresent();
    }
    public UserProfile createUser(UserProfile userProfile) {
        kafkaProducer.sendMessage(userProfile);
        return userRepository.save(userProfile);
    }
    public List<UserProfile> getUsers() {
        return userRepository.findAll();
    }
}
