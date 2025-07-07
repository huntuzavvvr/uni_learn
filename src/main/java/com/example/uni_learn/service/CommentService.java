package com.example.uni_learn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.uni_learn.Repository.CommentRepository;
import com.example.uni_learn.dto.CommentResponseDto;
import com.example.uni_learn.mapper.CommentMapper;
import com.example.uni_learn.model.Comment;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper){
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public List<CommentResponseDto> getComments(){
        return commentRepository.findAll().stream().map(commentMapper::toCommentResponseDto).collect(Collectors.toList());
    }

    public CommentResponseDto addComment(Comment comment){
        commentRepository.save(comment);
        return commentMapper.toCommentResponseDto(comment);
    }
}
