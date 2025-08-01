package com.Trackers.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "workout_plans")
public class WorkoutPlan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(nullable = false)
    private String monday;
    
    @Column(nullable = false)
    private String wednesday;
    
    @Column(nullable = false)
    private String friday;
    
    @Column(nullable = false)
    private LocalDate createdDate;
    
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
    
    public String getMonday() {
        return monday;
    }
    
    public void setMonday(String monday) {
        this.monday = monday;
    }
    
    public String getWednesday() {
        return wednesday;
    }
    
    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }
    
    public String getFriday() {
        return friday;
    }
    
    public void setFriday(String friday) {
        this.friday = friday;
    }
    
    public LocalDate getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}