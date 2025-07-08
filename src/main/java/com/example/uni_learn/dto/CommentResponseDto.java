package com.example.uni_learn.dto;

import lombok.Data;

@Data
public class CommentResponseDto {
    private Integer id;
    private String text;
    private Integer lectureId;
}
