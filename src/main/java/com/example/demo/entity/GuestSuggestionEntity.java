package com.example.demo.entity;

import com.example.demo.enums.SuggestionStatus;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class GuestSuggestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long rate;
    private String suggestionText;

    @Enumerated(EnumType.STRING)
    private SuggestionStatus status;

    public SuggestionStatus getStatus() {
        return status;
    }

    public void setStatus(SuggestionStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestSuggestionEntity that = (GuestSuggestionEntity) o;
        return Objects.equals(rate, that.rate) && Objects.equals(suggestionText, that.suggestionText) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, suggestionText, status);
    }
}

