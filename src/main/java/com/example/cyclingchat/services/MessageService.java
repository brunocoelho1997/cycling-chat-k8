package com.example.cyclingchat.services;

import com.example.cyclingchat.entities.Message;
import com.example.cyclingchat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;


    public void createMessage(String content) {

        Message message = new Message();
        message.setContent(content);

        Optional<String> hostname = Optional.ofNullable(System.getenv("HOSTNAME"));

        message.setPodName(hostname.orElse("unrecognized pod"));

        messageRepository.save(message);
    }

}
