package com.example.uni_learn.model;

import java.util.List;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
public class Category extends BaseEntity{
    @Id
    @GeneratedValue
    private Integer id;
    
    private String title;

    @ManyToMany(mappedBy = "categories")
    private List<Course> courses;
}
