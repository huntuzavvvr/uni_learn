package com.example.uni_learn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue
    private Integer id;

    private String text;

    @ManyToOne
    private Lecture lecture;
}
