package com.example.uni_learn.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentDto {
    @NotBlank(message = "Текст комментария не может быть пустым")
    private String text;
    @NotNull(message = "Id лекции не может быть пустым")
    private Integer lectureId;
}
