package com.example.uni_learn.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.uni_learn.Repository.CategoryRepository;
import com.example.uni_learn.dto.CourseDto;
import com.example.uni_learn.model.Category;
import com.example.uni_learn.model.Course;

@Component
public class CourseMapper {

    private CategoryRepository categoryRepository;

    public CourseMapper(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Course toEntity(CourseDto courseDto){
        List<Category> categories = categoryRepository.findAllById(courseDto.getCategoryIds());
        Course course = new Course();
        course.setAuthor(courseDto.getAuthor());
        course.setTitle(courseDto.getTitle());
        course.setCategories(categories);
        return course;
    }
}
