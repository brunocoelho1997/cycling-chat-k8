package com.example.cyclingchat.rabbit_processors;


import com.example.cyclingchat.CyclingchatApplication;
import com.example.cyclingchat.services.MessageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @Autowired
    MessageService messageService;

    @RabbitListener(queues = CyclingchatApplication.queueName)
    public void consumeMessage(String content) {

        messageService.createMessage(content);

        //System.out.println("Consumed Message From RabbitMQ: " + message);
    }
}