package com.example.uni_learn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uni_learn.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
    
}
