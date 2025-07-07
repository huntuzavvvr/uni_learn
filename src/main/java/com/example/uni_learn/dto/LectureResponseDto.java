package com.example.uni_learn.dto;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class LectureResponseDto {
    private String title;

    // @Nullable
    private Integer course_id;
}
