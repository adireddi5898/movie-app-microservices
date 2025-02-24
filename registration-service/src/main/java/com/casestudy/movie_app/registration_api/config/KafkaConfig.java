package com.casestudy.movie_app.registration_api.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name("user-topic")
                .build();
    }
}
