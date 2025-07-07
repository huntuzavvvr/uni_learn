package com.example.uni_learn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.uni_learn.Repository.CourseRepository;
import com.example.uni_learn.dto.CourseResponseDto;
import com.example.uni_learn.mapper.CourseMapper;
import com.example.uni_learn.model.Course;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    private CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper){
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }


    public List<CourseResponseDto> getCourses(){
        return courseRepository.findAll().stream().map(courseMapper::toCourseResponseDto).collect(Collectors.toList());
    }

    public CourseResponseDto addCourse(Course course){
        courseRepository.save(course);
        return courseMapper.toCourseResponseDto(course);
    }
}
