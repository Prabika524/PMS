package com.Trackers.repository;

import com.Trackers.model.Member;
import com.Trackers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUser(User user);
    boolean existsByUser(User user);
}