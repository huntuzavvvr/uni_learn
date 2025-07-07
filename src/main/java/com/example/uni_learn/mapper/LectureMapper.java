package com.example.uni_learn.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.uni_learn.Repository.CourseRepository;
import com.example.uni_learn.dto.LectureDto;
import com.example.uni_learn.dto.LectureResponseDto;
import com.example.uni_learn.model.Course;
import com.example.uni_learn.model.Lecture;

@Component
public class LectureMapper {

    private CourseRepository courseRepository;

    public LectureMapper(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public Lecture toLecture(LectureDto lectureDto){
        Lecture lecture = new Lecture();
        lecture.setTitle(lectureDto.getTitle());
        lecture.setCourse(courseRepository.findById(lectureDto.getCourse_id()).orElse(null));
        return lecture;
    }

    public LectureResponseDto toLectureResponseDto(Lecture lecture){
        LectureResponseDto lectureResponseDto = new LectureResponseDto();
        lectureResponseDto.setTitle(lecture.getTitle());
        // lectureResponseDto.setCourse_id(lecture.getCourse().getId());
        lectureResponseDto.setCourse_id(Optional.ofNullable(lecture.getCourse()).map(Course::getId).orElse(null));
        
        return lectureResponseDto;
    }    
}
