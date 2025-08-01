package com.Trackers.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "progress_tracking")
public class ProgressTracking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(name = "weight_change")
    private double weightChange;
    
    @Column(name = "workouts_completed")
    private int workoutsCompleted;
    
    @Column(name = "total_workouts")
    private int totalWorkouts;
    
    @Column(name = "goal_progress")
    private double goalProgress;
    
    @Column(nullable = false)
    private LocalDate date;
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public double getWeightChange() {
        return weightChange;
    }
    
    public void setWeightChange(double weightChange) {
        this.weightChange = weightChange;
    }
    
    public int getWorkoutsCompleted() {
        return workoutsCompleted;
    }
    
    public void setWorkoutsCompleted(int workoutsCompleted) {
        this.workoutsCompleted = workoutsCompleted;
    }
    
    public int getTotalWorkouts() {
        return totalWorkouts;
    }
    
    public void setTotalWorkouts(int totalWorkouts) {
        this.totalWorkouts = totalWorkouts;
    }
    
    public double getGoalProgress() {
        return goalProgress;
    }
    
    public void setGoalProgress(double goalProgress) {
        this.goalProgress = goalProgress;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
}