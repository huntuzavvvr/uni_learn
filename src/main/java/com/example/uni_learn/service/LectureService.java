package com.example.uni_learn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.uni_learn.Repository.LectureRepository;
import com.example.uni_learn.dto.LectureResponseDto;
import com.example.uni_learn.mapper.LectureMapper;
import com.example.uni_learn.model.Lecture;

@Service
public class LectureService {

    private LectureRepository lectureRepository;
    private LectureMapper lectureMapper;

    public LectureService(LectureRepository lectureRepository, LectureMapper lectureMapper){
        this.lectureRepository = lectureRepository;
        this.lectureMapper = lectureMapper;
    }

    public List<LectureResponseDto> getLectures(){
        return lectureRepository.findAll().stream().map(lectureMapper::toLectureResponseDto).collect(Collectors.toList());
    }

    public Lecture addLecture(Lecture lecture){
        return lectureRepository.save(lecture);
    }
}
