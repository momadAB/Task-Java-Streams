package com.example.demo.repository;

import com.example.demo.entity.GuestSuggestionEntity;
import com.example.demo.enums.SuggestionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestSuggestionRepository extends JpaRepository<GuestSuggestionEntity, Long> {
    public List<GuestSuggestionEntity> findByStatus(SuggestionStatus status);
}
