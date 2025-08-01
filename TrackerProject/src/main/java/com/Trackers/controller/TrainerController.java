package com.Trackers.controller;

import com.Trackers.model.TrainerSuggestion;
import com.Trackers.model.User;
import com.Trackers.model.WorkoutPlan;
import com.Trackers.service.TrainerSuggestionService;
import com.Trackers.service.UserDetailsImpl;
import com.Trackers.service.UserService;
import com.Trackers.service.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TrainerController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private WorkoutPlanService workoutPlanService;
    
    @Autowired
    private TrainerSuggestionService trainerSuggestionService;
    
    @GetMapping("/trainer")
    public String trainerDashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User trainer = userService.getUserById(((UserDetailsImpl) auth.getPrincipal()).getId());
        
        List<User> users = userService.getAllUsers();
        
        model.addAttribute("trainer", trainer);
        model.addAttribute("users", users);
        model.addAttribute("workoutPlan", new WorkoutPlan());
        model.addAttribute("suggestion", new TrainerSuggestion());
        
        return "trainer";
    }
    
    @PostMapping("/trainer/addWorkoutPlan")
    public String addWorkoutPlan(@ModelAttribute("workoutPlan") WorkoutPlan workoutPlan) {
        workoutPlanService.saveWorkoutPlan(workoutPlan);
        return "redirect:/trainer";
    }
    
    @PostMapping("/trainer/addSuggestion")
    public String addSuggestion(@ModelAttribute("suggestion") TrainerSuggestion suggestion) {
        trainerSuggestionService.saveSuggestion(suggestion);
        return "redirect:/trainer";
    }
}