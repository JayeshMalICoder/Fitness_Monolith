package com.project.fitness_monolith.dto;

import com.project.fitness_monolith.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRequest {
    private String userId;
    private ActivityType type;
    private Map<String, Object> additionalMetrices;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDate startTime;

}
