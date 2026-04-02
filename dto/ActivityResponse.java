package com.project.fitness_monolith.dto;

import com.project.fitness_monolith.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ActivityResponse {
    private String id;
    private String userId;
    private ActivityType type;
    private Map<String, Object> additionalMetrices;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDate startTime;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
