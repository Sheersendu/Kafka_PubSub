package com.Kafka.PubSub.KafkaTopics;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaTopicInitializer {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.topic-name}")
    private String topicName;

    @Bean
    public AdminClient adminClient() {
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return AdminClient.create(config);
    }

    @PostConstruct
    public void createTopic() {
        AdminClient adminClient = adminClient();

        // Specify the topic details
        NewTopic newTopic = new NewTopic(topicName, 1, (short) 1);

        // Create the topic
        adminClient.createTopics(Collections.singleton(newTopic));
    }
}
