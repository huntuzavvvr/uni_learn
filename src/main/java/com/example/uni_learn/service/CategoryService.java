package com.example.uni_learn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.uni_learn.Repository.CategoryRepository;
import com.example.uni_learn.model.Category;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }
}
