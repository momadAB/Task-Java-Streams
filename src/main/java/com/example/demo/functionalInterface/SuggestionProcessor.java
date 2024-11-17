package com.example.demo.functionalInterface;

import com.example.demo.bo.CreateSuggestionRequest;

@FunctionalInterface
public interface SuggestionProcessor {
    void processSuggestion(CreateSuggestionRequest request);
}
