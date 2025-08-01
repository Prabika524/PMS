package com.Trackers.service;

import com.Trackers.model.User;
import com.Trackers.model.TrainerSuggestion;
import com.Trackers.repository.TrainerSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainerSuggestionService {
    
    @Autowired
    private TrainerSuggestionRepository trainerSuggestionRepository;
    
    public TrainerSuggestion saveSuggestion(TrainerSuggestion suggestion) {
        suggestion.setDate(LocalDate.now());
        return trainerSuggestionRepository.save(suggestion);
    }
    
    public List<TrainerSuggestion> getSuggestionsByUser(User user) {
        return trainerSuggestionRepository.findByUser(user);
    }
}