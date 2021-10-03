package com.example.cyclingchat.repositories;

import com.example.cyclingchat.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Message findById(long id);

}
