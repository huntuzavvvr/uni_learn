package com.example.uni_learn.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.uni_learn.dto.CommentDto;
import com.example.uni_learn.dto.CommentResponseDto;
import com.example.uni_learn.exception.ApiError;
import com.example.uni_learn.mapper.CommentMapper;
import com.example.uni_learn.model.Comment;
import com.example.uni_learn.service.CommentService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CommentContoller {

    private CommentService commentService;
    private CommentMapper commentMapper;

    public CommentContoller(CommentService commentService, CommentMapper commentMapper){
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @GetMapping("/comments")
    public List<CommentResponseDto> getComments() {
        return commentService.getComments();
    }

    @GetMapping("/comments/{id}")
    public CommentResponseDto getCommentById(@PathVariable Integer id) {
        return commentService.getCommentById(id);
    }
    

    @GetMapping("/lectures/{lectureId}/comments")
    public List<CommentResponseDto> getCommentsByLectureId(@PathVariable Integer lectureId) {
        return commentService.getCommentsByLectureId(lectureId);
    }
    
    
    @PostMapping("/comments")
    public CommentResponseDto addComment(@Valid @RequestBody CommentDto commentDto) {
        Comment comment = commentMapper.toComment(commentDto);
        return commentService.addComment(comment);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<ApiError> deleteCommentById(@PathVariable Integer id){
        commentService.deleteCommentById(id);
        return ResponseEntity.noContent().build();
    }
}
