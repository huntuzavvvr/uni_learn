package com.example.uni_learn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.uni_learn.Repository.CourseRepository;
import com.example.uni_learn.Repository.LectureRepository;
import com.example.uni_learn.dto.LectureResponseDto;
import com.example.uni_learn.mapper.LectureMapper;
import com.example.uni_learn.model.Lecture;

@Service
public class LectureService {

    
    private CourseRepository courseRepository;
    private LectureRepository lectureRepository;
    private LectureMapper lectureMapper;

    public LectureService(LectureRepository lectureRepository, LectureMapper lectureMapper, CourseRepository courseRepository){
        this.lectureRepository = lectureRepository;
        this.lectureMapper = lectureMapper;
        this.courseRepository = courseRepository;
    }

    public List<LectureResponseDto> getLectures(){
        return lectureRepository.findAll().stream().map(lectureMapper::toLectureResponseDto).collect(Collectors.toList());
    }

    public LectureResponseDto addLecture(Lecture lecture){
        lectureRepository.save(lecture);
        return lectureMapper.toLectureResponseDto(lecture);
    }

    public List<LectureResponseDto> getLecturesByCourse(String courseName){
        return lectureRepository.findAllByCourseTitle(courseName).stream().map(lectureMapper::toLectureResponseDto).collect(Collectors.toList());
    }
}
