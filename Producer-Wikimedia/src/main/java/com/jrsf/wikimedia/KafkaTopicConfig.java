package com.jrsf.wikimedia;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic wiki() {
        return TopicBuilder.name("wikimedia")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
