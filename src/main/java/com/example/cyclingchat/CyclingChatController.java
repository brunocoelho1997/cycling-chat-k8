package com.example.cyclingchat;

import com.example.cyclingchat.entities.Message;
import com.example.cyclingchat.services.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class CyclingChatController {

    @Autowired
    MessageService messageService;

    @GetMapping("/messages")
    public List<Message> all(@RequestParam(name = "numberOfMessages", defaultValue = "10") String numberOfMessages) {
        log.info("Requested to return the last {} messages!", numberOfMessages);

        return messageService.getMessages(Integer.parseInt(numberOfMessages));

    }

    @GetMapping("/createmessage")
    public String createMessage() {
        log.info("Hello world!");

        messageService.createMessage("asd");

        return "Hello world!";
    }
}
