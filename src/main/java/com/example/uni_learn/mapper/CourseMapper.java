package com.example.uni_learn.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.uni_learn.Repository.CategoryRepository;
import com.example.uni_learn.dto.CourseDto;
import com.example.uni_learn.dto.CourseResponseDto;
import com.example.uni_learn.model.Category;
import com.example.uni_learn.model.Course;

@Component
public class CourseMapper {

    private CategoryRepository categoryRepository;

    private CategoryMapper categoryMapper;

    public CourseMapper(@Lazy CategoryRepository categoryRepository, CategoryMapper categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public Course toEntity(CourseDto courseDto){
        List<Category> categories = categoryRepository.findAllById(courseDto.getCategoryIds());
        Course course = new Course();
        course.setAuthor(courseDto.getAuthor());
        course.setTitle(courseDto.getTitle());
        course.setCategories(categories);
        return course;
    }

    public CourseDto toCourseDto(Course course){
        CourseDto courseDto = new CourseDto();
        courseDto.setAuthor(course.getAuthor());
        courseDto.setTitle(course.getTitle());
        return courseDto;
    }

    public CourseResponseDto toCourseResponseDto(Course course){
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setAuthor(course.getAuthor());
        courseResponseDto.setTitle(course.getTitle());

        courseResponseDto.setCategories(course.getCategories().stream().map(categoryMapper::toCategoryDto).collect(Collectors.toList()));

        return courseResponseDto;
    }

}
