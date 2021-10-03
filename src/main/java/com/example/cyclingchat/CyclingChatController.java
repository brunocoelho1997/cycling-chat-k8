package com.example.cyclingchat;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class CyclingChatController {

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/messages")
    String all() {
        log.info("Hello world!");
        return "Hello world!";
    }
}
