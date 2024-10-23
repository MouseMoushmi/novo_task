package com.learning.novosoft.repository;

import com.learning.novosoft.model.ChatBot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  // Optional, but good practice
public interface ChatBotRepository extends MongoRepository<ChatBot, Integer> {
    Optional<ChatBot> findTopByOrderByIdDesc();
}