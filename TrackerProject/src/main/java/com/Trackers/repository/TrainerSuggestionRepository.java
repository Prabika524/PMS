package com.Trackers.repository;

import com.Trackers.model.User;
import com.Trackers.model.TrainerSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerSuggestionRepository extends JpaRepository<TrainerSuggestion, Long> {
    List<TrainerSuggestion> findByUser(User user);
}