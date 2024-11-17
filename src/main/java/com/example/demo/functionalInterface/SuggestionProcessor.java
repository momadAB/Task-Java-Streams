package com.example.demo.functionalInterface;

import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.enums.SuggestionStatus;

@FunctionalInterface
public interface SuggestionProcessor {
    void processSuggestion(CreateSuggestionRequest request);
}
