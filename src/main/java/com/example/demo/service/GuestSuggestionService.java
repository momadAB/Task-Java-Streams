package com.example.demo.service;

import com.example.demo.entity.GuestSuggestionEntity;
import com.example.demo.functionalInterface.SuggestionProcessor;
import com.example.demo.repository.GuestSuggestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestSuggestionService {
    private final GuestSuggestionRepository guestSuggestionRepository;
    private final SuggestionProcessor suggestion;

    public GuestSuggestionService(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;

        // Declare suggestion method by using lambda expression
        this.suggestion = suggestionText -> {
            GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
            suggestionEntity.setSuggestionText(suggestionText);
            suggestionEntity.setRate(5L);
            guestSuggestionRepository.save(suggestionEntity);
        };
    }

    public void processSuggestion(String suggestion) {
        this.suggestion.processSuggestion(suggestion);
    }

    public List<GuestSuggestionEntity> getSuggestions() {
        return guestSuggestionRepository.findAll();
    }
}
