package com.example.cyclingchat.repositories;

import com.example.cyclingchat.entities.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Message findById(long id);

    public List<Message> findAllByOrderByIdDesc();

}
