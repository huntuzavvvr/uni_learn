package com.example.uni_learn.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LectureDto {
    @NotBlank(message = "Название лекции не может быть пустым")
    private String title;
    @NotNull(message = "Id курса не может пустым")
    private Integer courseId;

}
