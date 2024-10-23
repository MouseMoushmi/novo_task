package com.learning.novosoft.service;



import com.learning.novosoft.model.ChatBot;
import com.learning.novosoft.repository.ChatBotRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatBotService {

    private final ChatBotRepository chatBotRepository;

    @Autowired
    public ChatBotService(ChatBotRepository chatBotRepository) {
        this.chatBotRepository = chatBotRepository;
    }


    public ChatBot createChatBot(ChatBot chatBot) {
        Optional<ChatBot> lastChatBot = chatBotRepository.findTopByOrderByIdDesc();
        int nextId = lastChatBot.map(bot -> bot.getId() + 1).orElse(1);
        chatBot.setId(nextId);
        return chatBotRepository.save(chatBot);
    }


    public List<ChatBot> getAllChatBots() {
        return chatBotRepository.findAll();
    }


    public Optional<ChatBot> getChatBotById(Integer id) {
        return chatBotRepository.findById(id);
    }


    public Optional<ChatBot> updateChatBot(Integer id, ChatBot chatBotDetails) {
        return chatBotRepository.findById(id).map(chatBot -> {
            chatBot.setTitle(chatBotDetails.getTitle());
            chatBot.setQuestion(chatBotDetails.getQuestion());
            chatBot.setAnswers(chatBotDetails.getAnswers());
            chatBot.setCategory(chatBotDetails.getCategory());
            chatBot.setActive(chatBotDetails.isActive());
            return chatBotRepository.save(chatBot);
        });
    }

    public boolean deleteChatBot(Integer id) {
        return chatBotRepository.findById(id).map(chatBot -> {
            chatBotRepository.delete(chatBot);
            return true;
        }).orElse(false);
    }
}