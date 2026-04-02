package com.project.fitness_monolith.dto;

import com.project.fitness_monolith.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RegisterRequest {
    @NotBlank(message = "Email is Required")
    @Email(message = "Invaild Email")
    private String email;
    @NotBlank(message = "Password is requied")
    private String password;
    private String firstname;
    private String lastname;
    private UserRole role;
}
