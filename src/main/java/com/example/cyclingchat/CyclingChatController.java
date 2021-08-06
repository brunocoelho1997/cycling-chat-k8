package com.example.cyclingchat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CyclingChatController {

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/messages")
    String all() {
        return "Hello world!";
    }
}
