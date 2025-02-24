package com.casestudy.movie_app.authentication.services;

import com.casestudy.movie_app.authentication.entity.User;
import com.casestudy.movie_app.authentication.repo.UserInfoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    UserInfoRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(topics = "user-topic", groupId = "user-group")
    public void serviceRegister(String user) {
        System.out.println("User: " + user);
        User userData;
        try {
            userData = objectMapper.readValue(user, User.class);
            userData.setPassword(passwordEncoder.encode(userData.getPassword()));
            userData.setUsername(userData.getUsername());
            System.out.println("UserData Added");
            userRepository.save(userData);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
