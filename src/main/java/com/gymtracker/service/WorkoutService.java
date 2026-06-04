package com.gymtracker.service;

import com.gymtracker.model.Workout;
import com.gymtracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public Workout addWorkout(Workout workout) {
        workout.setDate(LocalDate.now());
        return workoutRepository.save(workout);
    }

    public List<Workout> getWorkouts(Long userId) {
        return workoutRepository.findByUserId(userId);
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}