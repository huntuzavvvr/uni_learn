package com.example.uni_learn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.uni_learn.dto.CourseDto;
import com.example.uni_learn.dto.CourseResponseDto;
import com.example.uni_learn.dto.LectureResponseDto;
import com.example.uni_learn.mapper.CourseMapper;
import com.example.uni_learn.model.Course;
import com.example.uni_learn.model.Lecture;
import com.example.uni_learn.service.CourseService;
import com.example.uni_learn.service.LectureService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CourseController {

    private CourseMapper courseMapper;
    private CourseService courseService;
    private LectureService lectureService;

    public CourseController(CourseMapper courseMapper, CourseService courseService, LectureService lectureService){
        this.courseMapper = courseMapper;
        this.courseService = courseService;
        this.lectureService = lectureService;
    }

    @GetMapping("/courses")
    public List<CourseResponseDto> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/courses/{id}")
    public CourseResponseDto getMethodName(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }
    
    @GetMapping("/courses/{id}/lectures")
    public List<LectureResponseDto> getLecturesByCourse(@PathVariable Integer id) {
        return lectureService.getLecturesByCourse(id);
    }
    

    @PostMapping("/courses")
    public CourseResponseDto addCourse(@Valid @RequestBody CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        return courseService.addCourse(course);
    }
}
