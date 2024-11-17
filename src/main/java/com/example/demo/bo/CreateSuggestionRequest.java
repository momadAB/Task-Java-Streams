package com.example.demo.bo;

import com.example.demo.enums.SuggestionStatus;

public class CreateSuggestionRequest {
    private String suggestionText;
    private SuggestionStatus status;

    public SuggestionStatus getStatus() {
        return status;
    }

    public void setStatus(SuggestionStatus status) {
        this.status = status;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }
}
