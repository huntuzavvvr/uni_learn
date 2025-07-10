package com.example.uni_learn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.uni_learn.Repository.CommentRepository;
import com.example.uni_learn.dto.CommentDto;
import com.example.uni_learn.dto.CommentResponseDto;
import com.example.uni_learn.dto.CommentUpdateDto;
import com.example.uni_learn.exception.ResourceNotFoundException;
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

    public CommentResponseDto getCommentById(Integer id){
        return commentMapper.toCommentResponseDto(commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Комментарий с id " + id + " не найден")));
    }

    public CommentResponseDto addComment(Comment comment){
        commentRepository.save(comment);
        return commentMapper.toCommentResponseDto(comment);
    }

    public List<CommentResponseDto> getCommentsByLectureId(Integer lectureId){
        return commentRepository.findAllByLectureId(lectureId).stream().map(commentMapper::toCommentResponseDto).collect(Collectors.toList());
    }

    public void deleteCommentById(Integer id){
        commentRepository.deleteById(id);
    }

    public CommentResponseDto updateComment(Integer id, CommentUpdateDto commentUpdateDto){
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Комментарий с id " + id + " не найден"));
        comment.setText(commentUpdateDto.getText());
        return commentMapper.toCommentResponseDto(commentRepository.save(comment));
    }
}
