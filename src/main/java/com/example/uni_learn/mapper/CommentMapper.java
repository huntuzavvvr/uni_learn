package com.example.uni_learn.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.uni_learn.Repository.CommentRepository;
import com.example.uni_learn.Repository.LectureRepository;
import com.example.uni_learn.dto.CommentDto;
import com.example.uni_learn.dto.CommentResponseDto;
import com.example.uni_learn.exception.ResourceNotFoundException;
import com.example.uni_learn.model.Comment;
import com.example.uni_learn.model.Lecture;

@Component
public class CommentMapper {

    private CommentRepository commentRepository;
    private LectureRepository lectureRepository;

    public CommentMapper(CommentRepository commentRepository, LectureRepository lectureRepository){
        this.commentRepository = commentRepository;
        this.lectureRepository = lectureRepository;
    }

    public Comment toComment(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setLecture(lectureRepository.findById(commentDto.getLectureId()).orElseThrow(() -> new ResourceNotFoundException("Не найдено")));
        return comment;
    }

    public CommentResponseDto toCommentResponseDto(Comment comment){
        CommentResponseDto commentResponseDto = new CommentResponseDto();
        commentResponseDto.setId(comment.getId());
        commentResponseDto.setText(comment.getText());
        // commentResponseDto.setLectureId(comment.getLecture().getId());
        commentResponseDto.setLectureId(Optional.ofNullable(comment.getLecture()).map(Lecture::getId).orElse(null));
        return commentResponseDto;
    }

}
