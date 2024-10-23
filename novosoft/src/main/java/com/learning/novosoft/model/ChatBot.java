package com.learning.novosoft.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Chat_bot")
public class ChatBot {

    @Id
    private Integer id;  // Integer type for manually handling ID

    @NotNull(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotNull(message = "Question is required")
    private String question;

    @NotNull(message = "Answers must be provided")
    private List<String> answers;

    private String category;
    private boolean active;

    // Constructors
    public ChatBot() {
    }

    public ChatBot(String title, String question, List<String> answers, String category, boolean active) {
        this.title = title;
        this.question = question;
        this.answers = answers;
        this.category = category;
        this.active = active;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}