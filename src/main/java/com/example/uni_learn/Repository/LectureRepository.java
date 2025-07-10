package com.example.uni_learn.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uni_learn.model.Lecture;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Integer>{
    public List<Lecture> findAllByCourseId(Integer courseId);
}
