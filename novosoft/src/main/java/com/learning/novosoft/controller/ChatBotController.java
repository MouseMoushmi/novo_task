package com.learning.novosoft.controller;




import com.learning.novosoft.model.ChatBot;
import com.learning.novosoft.service.ChatBotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chatbot")
public class ChatBotController {

    @Autowired
    private ChatBotService chatBotService;


    @PostMapping("/create")
    public ResponseEntity<ChatBot> createChatBot(@Valid @RequestBody ChatBot chatBot) {
        ChatBot createdChatBot = chatBotService.createChatBot(chatBot);
        return new ResponseEntity<>(createdChatBot, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<ChatBot>> getAllChatBots() {
        List<ChatBot> chatBots = chatBotService.getAllChatBots();
        if (chatBots.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(chatBots, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ChatBot> getChatBotById(@PathVariable Integer id) {
        Optional<ChatBot> chatBot = chatBotService.getChatBotById(id);
        return chatBot.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ChatBot> updateChatBot(@PathVariable Integer id, @Valid @RequestBody ChatBot chatBotDetails) {
        Optional<ChatBot> updatedChatBot = chatBotService.updateChatBot(id, chatBotDetails);
        return updatedChatBot.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChatBot(@PathVariable Integer id) {
        boolean isDeleted = chatBotService.deleteChatBot(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}