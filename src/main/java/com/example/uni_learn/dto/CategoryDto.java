package com.example.uni_learn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDto {
    @NotBlank(message = "Название категории не может быть пустым")
    private String title;

}
