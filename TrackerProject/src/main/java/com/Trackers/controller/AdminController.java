package com.Trackers.controller;

import com.Trackers.model.Trainer;
import com.Trackers.model.User;
import com.Trackers.service.TrainerService;
import com.Trackers.service.UserDetailsImpl;
import com.Trackers.service.UserService;
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
public class AdminController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TrainerService trainerService;
    
    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User admin = userService.getUserById(((UserDetailsImpl) auth.getPrincipal()).getId());
        
        List<User> users = userService.getAllUsers();
        List<Trainer> trainers = trainerService.getAllTrainers();
        
        model.addAttribute("admin", admin);
        model.addAttribute("users", users);
        model.addAttribute("trainers", trainers);
        model.addAttribute("newTrainer", new Trainer());
        model.addAttribute("newUser", new User());
        
        return "admin";
    }
    
    @PostMapping("/admin/addTrainer")
    public String addTrainer(@ModelAttribute("newTrainer") Trainer trainer) {
        trainerService.saveTrainer(trainer);
        return "redirect:/admin";
    }
    
    @PostMapping("/admin/addUser")
    public String addUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }
}