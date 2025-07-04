package com.example.uni_learn.dto;

import java.util.List;

import lombok.Data;

@Data
public class CourseDto {
    private String author;
    private String title;
    private List<Integer> categoryIds;
}
