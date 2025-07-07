package com.example.uni_learn.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.uni_learn.dto.CategoryDto;
import com.example.uni_learn.dto.CategoryResponseDto;
import com.example.uni_learn.dto.CommentDto;
import com.example.uni_learn.dto.CommentResponseDto;
import com.example.uni_learn.dto.CourseDto;
import com.example.uni_learn.dto.CourseResponseDto;
import com.example.uni_learn.dto.LectureDto;
import com.example.uni_learn.dto.LectureResponseDto;
import com.example.uni_learn.mapper.CategoryMapper;
import com.example.uni_learn.mapper.CommentMapper;
import com.example.uni_learn.mapper.CourseMapper;
import com.example.uni_learn.mapper.LectureMapper;
import com.example.uni_learn.model.Category;
import com.example.uni_learn.model.Comment;
import com.example.uni_learn.model.Course;
import com.example.uni_learn.model.Lecture;
import com.example.uni_learn.service.CategoryService;
import com.example.uni_learn.service.CommentService;
import com.example.uni_learn.service.CourseService;
import com.example.uni_learn.service.LectureService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UniLearnController {

    private final CategoryService categoryService;
    
    private CourseService courseService;
    private CourseMapper courseMapper;
    private CategoryMapper categoryMapper;
    private LectureService lectureService;
    private LectureMapper lectureMapper;
    private CommentService commentService;
    private CommentMapper commentMapper;

    public UniLearnController(CourseService courseService, CourseMapper courseMapper, 
    CategoryService categoryService, CategoryMapper categoryMapper, 
    LectureService lectureService, LectureMapper lectureMapper, 
    CommentService commentService, CommentMapper commentMapper){
        this.courseService = courseService;
        this.courseMapper = courseMapper;
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
        this.lectureService = lectureService;
        this.lectureMapper = lectureMapper;
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    // Получить все курсы 

    // В категории пишутся названия курсов которые так же относятся к категории
    @GetMapping("/courses")
    public List<CourseResponseDto> getCourses() {
        return courseService.getCourses();
    }
    
    // Добавить курс

    @PostMapping("/courses")
    public CourseResponseDto addCourse(@RequestBody CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        return courseService.addCourse(course);
    }
    
    // Получить все категории
    // В курсах пишутся категории к которым так же относится курс

    @GetMapping("/categories")
    public List<CategoryResponseDto> getCategories() {
        return categoryService.getCategories();
    }
    
    // Добавить категорию

    @PostMapping("/categories")
    public Category addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto); 
        return categoryService.addCategory(category);
    }
    
    // Получить все лекции

    @GetMapping("/lectures")
    public List<LectureResponseDto> getLectures() {
        return lectureService.getLectures();
    }
    
    // Добавить лекцию
    @PostMapping("/lectures")
    public Lecture addLecture(@RequestBody LectureDto lectureDto) {
        Lecture lecture = lectureMapper.toLecture(lectureDto);
        return lectureService.addLecture(lecture);
    }
    
    // Получить все комментарии

    @GetMapping("/comments")
    public List<CommentResponseDto> getComments() {
        return commentService.getComments();
    }
    
    @PostMapping("/comments")
    public Comment addComment(@RequestBody CommentDto commentDto) {
        //TODO: process POST request
        Comment comment = commentMapper.toComment(commentDto);
        return commentService.addComment(comment);
    }
    
}
