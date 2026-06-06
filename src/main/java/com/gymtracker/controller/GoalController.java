package com.gymtracker.controller;

import com.gymtracker.model.Goal;
import com.gymtracker.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin(origins = "*")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @PostMapping("/add")
    public Goal addGoal(@RequestBody Goal goal) {
        return goalService.addGoal(goal);
    }

    // Support both URL patterns
    @GetMapping("/{userId}")
    public List<Goal> getGoals(@PathVariable Long userId) {
        return goalService.getGoals(userId);
    }

    @GetMapping("/user/{userId}")
    public List<Goal> getGoalsByUser(@PathVariable Long userId) {
        return goalService.getGoals(userId);
    }

    @PutMapping("/{id}/achieve")
    public Goal markAsAchieved(@PathVariable Long id) {
        return goalService.markAsAchieved(id);
    }

    @PutMapping("/achieved/{id}")
    public Goal markAsAchievedAlt(@PathVariable Long id) {
        return goalService.markAsAchieved(id);
    }
}