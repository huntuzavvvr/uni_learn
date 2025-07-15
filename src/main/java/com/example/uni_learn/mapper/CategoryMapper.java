package com.example.uni_learn.mapper;



import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.uni_learn.dto.CategoryDto;
import com.example.uni_learn.dto.CategoryResponseDto;
import com.example.uni_learn.dto.CourseDto;
import com.example.uni_learn.model.Category;
import com.example.uni_learn.model.Course;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setTitle(categoryDto.getTitle());
        return category;
    }

    public CategoryDto toCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setTitle(category.getTitle());
        return categoryDto;
    }

    public CategoryResponseDto toCategoryResponseDto(Category category){
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setTitle(category.getTitle());
        categoryResponseDto.setCourses(category.getCourses().stream().map(tempCategory -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setAuthor(tempCategory.getAuthor());
            courseDto.setTitle(tempCategory.getTitle());
            courseDto.setCategoryIds(tempCategory.getCategories().stream().map(cat -> cat.getId()).collect(Collectors.toList()));
            return courseDto;
        }).collect(Collectors.toList()));
        return categoryResponseDto;
    }
}
