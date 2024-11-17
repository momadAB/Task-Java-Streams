package com.example.demo.service;

import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.entity.GuestSuggestionEntity;
import com.example.demo.enums.SuggestionStatus;
import com.example.demo.functionalInterface.SuggestionProcessor;
import com.example.demo.repository.GuestSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestSuggestionService {
    private final GuestSuggestionRepository guestSuggestionRepository;
    private final SuggestionProcessor suggestion;

    public GuestSuggestionService(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;

        // Declare suggestion method by using lambda expression
        this.suggestion = request -> {
            GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
            suggestionEntity.setSuggestionText(request.getSuggestionText());
            suggestionEntity.setRate(5L);
            suggestionEntity.setStatus(request.getStatus());
            guestSuggestionRepository.save(suggestionEntity);
        };
    }

    public void processSuggestion(CreateSuggestionRequest request) {
        this.suggestion.processSuggestion(request);
    }

    public List<GuestSuggestionEntity> getSuggestions() {
        return guestSuggestionRepository.findAll();
    }

    // Return list of suggestions without duplicates
    // Duplicates being suggestions with the same text, rate, and status
    // It is done by having the GuestSuggestionEntity .equals() and .hashCode() methods overridden
    public List<GuestSuggestionEntity> getSuggestionsNoDuplicates() {
        return guestSuggestionRepository.findAll().stream().distinct().toList();
    }

    public List<GuestSuggestionEntity> findAllCreatedSuggestions() {
        return guestSuggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getStatus().equals(SuggestionStatus.CREATE)).toList();
    }

    public List<GuestSuggestionEntity> findAllRemovedSuggestions() {
        return guestSuggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getStatus().equals(SuggestionStatus.REMOVE)).toList();
    }
}
