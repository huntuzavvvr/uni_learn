package com.example.uni_learn.dto;

import java.util.List;

import lombok.Data;

@Data
public class CourseResponseDto {
    private String author;
    private String title;
    private List<CategoryDto> categories; 
}
