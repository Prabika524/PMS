package com.Trackers.service;

import com.Trackers.model.User;
import com.Trackers.model.ProgressTracking;
import com.Trackers.repository.ProgressTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProgressTrackingService {
    
    @Autowired
    private ProgressTrackingRepository progressTrackingRepository;
    
    public ProgressTracking saveProgressTracking(ProgressTracking progressTracking) {
        progressTracking.setDate(LocalDate.now());
        return progressTrackingRepository.save(progressTracking);
    }
    
    public List<ProgressTracking> getProgressTrackingByUser(User user) {
        return progressTrackingRepository.findByUser(user);
    }
}