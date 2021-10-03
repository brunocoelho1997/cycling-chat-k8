package com.example.cyclingchat;

import com.example.cyclingchat.services.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class CyclingChatController {

    @Autowired
    MessageService messageService;

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/messages")
    String all() {
        log.info("Hello world!");

        messageService.createMessage("asd");

        return "Hello world!";
    }
}
