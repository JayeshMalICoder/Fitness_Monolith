package com.project.fitness_monolith.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserResponse {
    private String id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String createdAt;
    private String updatedAt;
}
