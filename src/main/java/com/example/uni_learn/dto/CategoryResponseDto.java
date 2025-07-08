package com.example.uni_learn.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoryResponseDto {
    private Integer id;
    private String title;
    private List<CourseDto> courses;
}