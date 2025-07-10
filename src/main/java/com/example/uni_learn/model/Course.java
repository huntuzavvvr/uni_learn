package com.example.uni_learn.model;

import java.util.List;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
public class Course extends BaseEntity{
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
