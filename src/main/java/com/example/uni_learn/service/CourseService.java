package com.example.uni_learn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.uni_learn.Repository.CourseRepository;
import com.example.uni_learn.model.Course;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }


    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }
}
