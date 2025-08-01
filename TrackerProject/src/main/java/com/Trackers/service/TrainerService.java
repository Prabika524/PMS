package com.Trackers.service;

import com.Trackers.model.Trainer;
import com.Trackers.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
    
    @Autowired
    private TrainerRepository trainerRepository;
    
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }
    
    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
    
    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id).orElse(null);
    }
    
    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }
}