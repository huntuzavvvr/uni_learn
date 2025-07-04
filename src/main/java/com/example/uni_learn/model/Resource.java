package com.example.uni_learn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Resource {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private Lecture lecture;
}
