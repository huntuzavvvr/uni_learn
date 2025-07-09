package com.example.uni_learn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.uni_learn.dto.LectureDto;
import com.example.uni_learn.dto.LectureResponseDto;
import com.example.uni_learn.mapper.LectureMapper;
import com.example.uni_learn.model.Lecture;
import com.example.uni_learn.service.LectureService;

import jakarta.validation.Valid;

@RestController
public class LectureController {

    private LectureService lectureService;
    private LectureMapper lectureMapper;

    public LectureController(LectureService lectureService, LectureMapper lectureMapper){
        this.lectureService = lectureService;
        this.lectureMapper = lectureMapper;
    }

    @GetMapping("/lectures")
    public List<LectureResponseDto> getLectures() {
        return lectureService.getLectures();
    }

    @GetMapping("{courseName}/lectures")
    public List<LectureResponseDto> getMethodName(@PathVariable String courseName) {
        return lectureService.getLecturesByCourse(courseName);
    }
    
    
    // Добавить лекцию
    @PostMapping("/lectures")
    public LectureResponseDto addLecture(@Valid @RequestBody LectureDto lectureDto) {
        Lecture lecture = lectureMapper.toLecture(lectureDto);
        return lectureService.addLecture(lecture);
    }
}
