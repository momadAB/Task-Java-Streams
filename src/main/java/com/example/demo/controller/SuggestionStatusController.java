package com.example.demo.controller;

import com.example.demo.entity.GuestSuggestionEntity;
import com.example.demo.service.GuestSuggestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SuggestionStatusController {
    private GuestSuggestionService guestSuggestionService;

    public SuggestionStatusController(GuestSuggestionService guestSuggestionService) {
        this.guestSuggestionService = guestSuggestionService;
    }

    @GetMapping("/status/created")
    public ResponseEntity<List<GuestSuggestionEntity>> getCreatedSuggestions() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(guestSuggestionService.findAllCreatedSuggestions());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/status/removed")
    public ResponseEntity<List<GuestSuggestionEntity>> getRemovedSuggestions() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(guestSuggestionService.findAllRemovedSuggestions());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
