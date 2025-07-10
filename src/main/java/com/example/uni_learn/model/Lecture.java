package com.example.uni_learn.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
public class Lecture {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    @ManyToOne
    private Course course;

    @OneToOne(mappedBy = "lecture")
    private Resource resource;

    @OneToMany(mappedBy = "lecture")
    private List<Comment> comments;
}
