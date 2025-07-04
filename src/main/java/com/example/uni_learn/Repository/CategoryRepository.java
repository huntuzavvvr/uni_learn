package com.example.uni_learn.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uni_learn.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}
