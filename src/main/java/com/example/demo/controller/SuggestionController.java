package com.example.demo.controller;

import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.entity.GuestSuggestionEntity;
import com.example.demo.service.GuestSuggestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SuggestionController {
    private GuestSuggestionService guestSuggestionService;

    public SuggestionController(GuestSuggestionService guestSuggestionService) {
        this.guestSuggestionService = guestSuggestionService;
    }

    @PostMapping("/suggestions/post")
    public ResponseEntity<String> createSuggestion(@RequestBody CreateSuggestionRequest request) {
        try {
            // Return bad request if field is null
            if(request.getSuggestionText() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            // Process suggestion
            guestSuggestionService.processSuggestion(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Successful creation.");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/suggestions")
    public ResponseEntity<List<GuestSuggestionEntity>> getSuggestions(@RequestParam(required = false) String duplicates) {
        try {
            if("false".equalsIgnoreCase(duplicates)) {
                return ResponseEntity.status(HttpStatus.OK).body(guestSuggestionService.getSuggestionsNoDuplicates());
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(guestSuggestionService.getSuggestions());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
