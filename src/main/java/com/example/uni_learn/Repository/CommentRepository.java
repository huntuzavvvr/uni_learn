package com.example.uni_learn.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uni_learn.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Integer>{
    public List<Comment> findAllByLectureId(Integer lectureId);
}
