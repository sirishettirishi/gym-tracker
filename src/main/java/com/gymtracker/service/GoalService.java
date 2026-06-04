package com.gymtracker.service;

import com.gymtracker.model.Goal;
import com.gymtracker.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public Goal addGoal(Goal goal) {
        goal.setAchieved(false);
        return goalRepository.save(goal);
    }

    public List<Goal> getGoals(Long userId) {
        return goalRepository.findByUserId(userId);
    }

    public Goal markAsAchieved(Long id) {
        Goal goal = goalRepository.findById(id).orElseThrow();
        goal.setAchieved(true);
        return goalRepository.save(goal);
    }
}