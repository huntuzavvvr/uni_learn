package com.example.uni_learn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.uni_learn.Repository.CategoryRepository;
import com.example.uni_learn.dto.CategoryResponseDto;
import com.example.uni_learn.exception.ResourceNotFoundException;
import com.example.uni_learn.mapper.CategoryMapper;
import com.example.uni_learn.model.Category;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    private CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryResponseDto> getCategories(){
        return categoryRepository.findAll().stream().map(categoryMapper::toCategoryResponseDto).collect(Collectors.toList());
    }

    public CategoryResponseDto getCategoryById(Integer id){
        return categoryMapper.toCategoryResponseDto(categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Категория с id " + id + " не найдена")));
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }
}
