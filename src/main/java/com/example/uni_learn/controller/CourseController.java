package com.example.uni_learn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.uni_learn.dto.CourseDto;
import com.example.uni_learn.dto.CourseResponseDto;
import com.example.uni_learn.mapper.CourseMapper;
import com.example.uni_learn.model.Course;
import com.example.uni_learn.service.CourseService;

import jakarta.validation.Valid;

@RestController
public class CourseController {

    private CourseMapper courseMapper;
    private CourseService courseService;

    public CourseController(CourseMapper courseMapper, CourseService courseService){
        this.courseMapper = courseMapper;
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<CourseResponseDto> getCourses() {
        return courseService.getCourses();
    }
    
    // Добавить курс

    @PostMapping("/courses")
    public CourseResponseDto addCourse(@Valid @RequestBody CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        return courseService.addCourse(course);
    }
}
