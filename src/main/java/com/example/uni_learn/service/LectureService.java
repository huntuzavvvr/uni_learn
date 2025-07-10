package com.example.uni_learn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.uni_learn.Repository.CourseRepository;
import com.example.uni_learn.Repository.LectureRepository;
import com.example.uni_learn.dto.LectureResponseDto;
import com.example.uni_learn.dto.LectureUpdateDto;
import com.example.uni_learn.exception.ResourceNotFoundException;
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

    public LectureResponseDto getLectureById(Integer id){
        return lectureMapper.toLectureResponseDto(lectureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Лекция с id " + id + " не найдена")));
    }

    public LectureResponseDto addLecture(Lecture lecture){
        lectureRepository.save(lecture);
        return lectureMapper.toLectureResponseDto(lecture);
    }

    public List<LectureResponseDto> getLecturesByCourse(Integer id){
        return lectureRepository.findAllByCourseId(id).stream().map(lectureMapper::toLectureResponseDto).collect(Collectors.toList());
    }

    public void deleteLectureById(Integer id){
        Lecture lecture = lectureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Лекция с id " + id + " не найдена"));
        lecture.getComments().forEach(comment -> comment.setLecture(null));
        lectureRepository.deleteById(id);
    }

    public LectureResponseDto updateLecture(Integer id, LectureUpdateDto lectureUpdateDto){
        Lecture lecture = lectureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Лекция с id " + id + " не найдена"));
        lecture.setTitle(lectureUpdateDto.getTitle());
        return lectureMapper.toLectureResponseDto(lectureRepository.save(lecture));
    }
}
