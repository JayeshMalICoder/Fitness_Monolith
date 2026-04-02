package com.project.fitness_monolith.service;

import com.project.fitness_monolith.dto.ActivityRequest;
import com.project.fitness_monolith.dto.ActivityResponse;
import com.project.fitness_monolith.model.Activity;
import com.project.fitness_monolith.model.User;
import com.project.fitness_monolith.repository.ActivityRepository;
import com.project.fitness_monolith.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

 private final ActivityRepository activityRepository;
 private final UserRepository userRepository;


    public ActivityResponse trackActivity(ActivityRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> (new RuntimeException("Invalid User" + request.getUserId() )));
        Activity activity = Activity.builder()
                .user(user)
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrices(request.getAdditionalMetrices())
                .build();
        Activity savedActivity = activityRepository.save(activity);
        return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity Activity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(Activity.getId());
        response.setUserId(Activity.getUser().getId());
        response.setType(Activity.getType());
        response.setDuration(Activity.getDuration());
        response.setCaloriesBurned(Activity.getCaloriesBurned());
        response.setStartTime(Activity.getStartTime());
        response.setAdditionalMetrices(Activity.getAdditionalMetrices());
        response.setCreatedAt(Activity.getCreatedAt());
        response.setUpdatedAt(Activity.getUpdatedAt());
        return response;
    }

    public List<ActivityResponse> getUserActivities(String userId) {
        List<Activity> activityList = activityRepository.findByUser_Id(userId);
        return activityList.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
}
