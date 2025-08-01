package com.Trackers.controller;

import com.Trackers.model.Member;
import com.Trackers.model.User;
import com.Trackers.service.MemberService;
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

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private MemberService memberService;
    
    @GetMapping("/user")
    public String userDashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.getUserById(((UserDetailsImpl) auth.getPrincipal()).getId());
        
        if (!memberService.isMemberExists(user)) {
            return "redirect:/join";
        }
        
        Member member = memberService.getMemberByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("member", member);
        return "user";
    }
    
    @GetMapping("/join")
    public String showJoinForm() {

        return "join";
    }
    
    @PostMapping("/post-join")
    public String processJoinForm(@ModelAttribute("member") Member member) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserById(((UserDetailsImpl) auth.getPrincipal()).getId());
        
        member.setUser(user);
        memberService.saveMember(member);
        return "redirect:/user";
    }
}