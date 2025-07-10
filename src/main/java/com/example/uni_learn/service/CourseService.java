package com.example.uni_learn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.uni_learn.Repository.CourseRepository;
import com.example.uni_learn.dto.CourseResponseDto;
import com.example.uni_learn.dto.CourseUpdateDto;
import com.example.uni_learn.exception.ResourceNotFoundException;
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

    public CourseResponseDto getCourseById(Integer id){
        return courseMapper.toCourseResponseDto(courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Курс с id " + id + " не найден")));
    }

    public CourseResponseDto addCourse(Course course){
        courseRepository.save(course);
        return courseMapper.toCourseResponseDto(course);
    }

    public void deleteCourseById(Integer id){
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Курс с id " + id + " не найден"));
        course.getLectures().forEach(lecture -> lecture.setCourse(null));
        courseRepository.deleteById(id);
    }

    public CourseResponseDto updateCourse(Integer id, CourseUpdateDto courseUpdateDto){
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Курс с id " + id + " не найден"));
        course.setTitle(courseUpdateDto.getTitle());
        return courseMapper.toCourseResponseDto(courseRepository.save(course));
    }
}
