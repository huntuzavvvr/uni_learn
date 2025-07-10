package com.example.uni_learn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseUpdateDto {
    @NotBlank(message = "Название курса не может быть пустым")
    private String title;
}
