package com.example.uni_learn.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
// @JsonIgnoreProperties(ignoreUnknown = false)
public class CommentUpdateDto {
    @NotBlank(message = "Текст комментария не может быть пустым")
    private String text;
}
