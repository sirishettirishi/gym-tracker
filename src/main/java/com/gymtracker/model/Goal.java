package com.gymtracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String goalDescription;
    private LocalDate targetDate;
    private boolean isAchieved;
    private Long userId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getGoalDescription() { return goalDescription; }
    public void setGoalDescription(String goalDescription) { this.goalDescription = goalDescription; }
    public LocalDate getTargetDate() { return targetDate; }
    public void setTargetDate(LocalDate targetDate) { this.targetDate = targetDate; }
    public boolean isAchieved() { return isAchieved; }
    public void setAchieved(boolean isAchieved) { this.isAchieved = isAchieved; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}