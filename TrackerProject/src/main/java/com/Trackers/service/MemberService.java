package com.Trackers.service;

import com.Trackers.model.Member;
import com.Trackers.model.User;
import com.Trackers.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    
    @Autowired
    private MemberRepository memberRepository;
    
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
    
    public Member getMemberByUser(User user) {
        return memberRepository.findByUser(user);
    }
    
    public boolean isMemberExists(User user) {
        return memberRepository.existsByUser(user);
    }
}