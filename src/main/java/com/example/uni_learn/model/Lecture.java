package com.example.uni_learn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Lecture {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    @ManyToOne
    private Course course;

    @OneToOne(mappedBy = "lecture")
    private Resource resource;
}
