package com.example.uni_learn.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseDto {
    @NotBlank(message = "Автор курса не может быть пустым")
    private String author;
    @NotBlank(message = "Название курса не может быть пустым")
    private String title;
    private List<Integer> categoryIds;
}
