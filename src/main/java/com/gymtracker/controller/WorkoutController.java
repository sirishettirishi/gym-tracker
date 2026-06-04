package com.gymtracker.controller;

import com.gymtracker.model.Workout;
import com.gymtracker.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@CrossOrigin(origins = "*")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @PostMapping("/add")
    public Workout addWorkout(@RequestBody Workout workout) {
        return workoutService.addWorkout(workout);
    }

    @GetMapping("/{userId}")
    public List<Workout> getWorkouts(@PathVariable Long userId) {
        return workoutService.getWorkouts(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
        return "Workout deleted!";
    }
}