package com.casestudy.movie_app.registration_api.service;

import com.casestudy.movie_app.registration_api.entity.AuthRequest;
import com.casestudy.movie_app.registration_api.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String USERTOPIC = "user-topic";

    public boolean sendMessage(UserProfile user) {
        System.out.print("=====> Sending UserProfile: " + user);
        AuthRequest authReq = new AuthRequest();
        authReq.setUsername(user.getUsername());
        authReq.setPassword(user.getPassword());
        Message<AuthRequest> message = MessageBuilder
                .withPayload(authReq)
                .setHeader(KafkaHeaders.TOPIC, USERTOPIC)
                .build();
        kafkaTemplate.send(message);
        System.out.print("=====> Message is produced: " + message);
        return true;
    }
}