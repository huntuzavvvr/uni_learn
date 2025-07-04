package com.example.uni_learn.mapper;



import org.springframework.stereotype.Component;

import com.example.uni_learn.dto.CategoryDto;
import com.example.uni_learn.model.Category;

@Component
public class CategoryMapper {
    public Category toEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setTitle(categoryDto.getTitle());
        return category;
    }
}
