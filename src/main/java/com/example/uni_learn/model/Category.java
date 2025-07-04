package com.example.uni_learn.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    
    private String title;

    @ManyToMany(mappedBy = "categories")
    private List<Course> courses;
}
