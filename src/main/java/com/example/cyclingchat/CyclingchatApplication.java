package com.example.cyclingchat;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CyclingchatApplication {

    public static final String queueName = "example-queue";

    public static void main(String[] args) {
        SpringApplication.run(CyclingchatApplication.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }
}
