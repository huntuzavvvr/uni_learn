package com.example.uni_learn.dto;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class LectureResponseDto {
    private Integer id;
    private String title;
    private Integer courseId;
}
