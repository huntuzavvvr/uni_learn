package com.example.uni_learn.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String author;

    @ManyToMany
    @JoinTable(
        name="course_category",
        joinColumns = @JoinColumn(name="course_id"),
        inverseJoinColumns = @JoinColumn(name="category_id")
    )
    private List<Category> categories;

    @OneToMany(mappedBy = "course")
    private List<Lecture> lectures;
}
