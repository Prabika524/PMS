package com.Trackers.service;

import com.Trackers.model.User;
import com.Trackers.model.WorkoutPlan;
import com.Trackers.repository.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkoutPlanService {
    
    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;
    
    public WorkoutPlan saveWorkoutPlan(WorkoutPlan workoutPlan) {
        workoutPlan.setCreatedDate(LocalDate.now());
        return workoutPlanRepository.save(workoutPlan);
    }
    
    public List<WorkoutPlan> getWorkoutPlansByUser(User user) {
        return workoutPlanRepository.findByUser(user);
    }
}