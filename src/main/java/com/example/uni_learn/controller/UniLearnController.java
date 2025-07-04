package com.example.uni_learn.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.uni_learn.dto.CategoryDto;
import com.example.uni_learn.dto.CourseDto;
import com.example.uni_learn.mapper.CategoryMapper;
import com.example.uni_learn.mapper.CourseMapper;
import com.example.uni_learn.model.Category;
import com.example.uni_learn.model.Course;
import com.example.uni_learn.service.CategoryService;
import com.example.uni_learn.service.CourseService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UniLearnController {

    private final CategoryService categoryService;
    
    private CourseService courseService;
    private CourseMapper courseMapper;
    private CategoryMapper categoryMapper;

    public UniLearnController(CourseService courseService, CourseMapper courseMapper, 
    CategoryService categoryService, CategoryMapper categoryMapper){
        this.courseService = courseService;
        this.courseMapper = courseMapper;
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        return courseService.addCourse(course);
    }
    
    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }
    

    @PostMapping("/categories")
    public Category addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto); 
        return categoryService.addCategory(category);
    }
    
    
}
