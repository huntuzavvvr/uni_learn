package com.example.uni_learn.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.uni_learn.dto.CategoryDto;
import com.example.uni_learn.dto.CategoryResponseDto;
import com.example.uni_learn.exception.ApiError;
import com.example.uni_learn.mapper.CategoryMapper;
import com.example.uni_learn.model.Category;
import com.example.uni_learn.service.CategoryService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class CategoryController {

    private CategoryService categoryService;
    private CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper){
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/categories")
    public List<CategoryResponseDto> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/categories/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }
    

    @PostMapping("/categories")
    public CategoryResponseDto addCategory(@Valid @RequestBody CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto); 
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<ApiError> deleteCategoryById(@PathVariable Integer id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/categories/{id}")
    public CategoryResponseDto updateCategory(@PathVariable Integer id, @Valid @RequestBody CategoryDto categoryDto) {        
        return categoryService.updateCategory(id, categoryDto);
    }
}
